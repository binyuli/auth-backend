package bz.sunlight.api;

import bz.sunlight.auth.DefaultTokenService;
import bz.sunlight.constant.OnlineManager;
import bz.sunlight.dto.LoginUserDTO;
import bz.sunlight.entity.UserCredential;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.service.AuthenticationService;
import bz.sunlight.service.Authorization;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.security.SignatureException;
import java.util.Arrays;

import static com.google.common.base.Strings.isNullOrEmpty;

@RestController
@RequestMapping(value = "/api/v1")
public class AuthController extends BaseContext {
  private final String authCookie = "token";

  @Autowired
  private Authorization authorizationService;
  @Autowired
  private AuthenticationService authenticationService;
  @Autowired
  private DefaultTokenService tokenService;

  /**
   * api访问权限校验.
   *
   * @return ResponseEntity
   * @throws Exception 异常
   */
  @RequestMapping(value = "/auth")
  public ResponseEntity<Void> isAuthorized(@RequestHeader(value = "X-Original-Method") String httpMethod,
                                           @RequestHeader(value = "X-Original-URI") String url,
                                           HttpServletRequest request) throws Exception {
    String requestPath;
    try {
      URI test = new URI(url);
      requestPath = test.getPath();
    } catch (Exception ex) {
      throw new BusinessException("不是有效的uri");
    }

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      String token = Arrays.stream(cookies)
                      .filter(c -> c.getName().equals(authCookie))
                      .map(Cookie::getValue)
                      .findFirst().orElse("");

      if (!isNullOrEmpty(token)) {
        Claims claims = tokenService.parseJwt(token);
        if (claims != null) {
          String userId = claims.getSubject();
          
          if (!isNullOrEmpty(userId)) {
            if (authorizationService.isAuthorized(httpMethod, requestPath, userId)) {
              return ResponseEntity.ok().header("X-USER-ID", userId).build();
            } else {
              return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
          }
        }
      }
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }

  /**
   * 登录.
   *
   * @param user 登录用户信息
   * @return ResponseEntity
   */
  @RequestMapping(method = RequestMethod.POST, value = "/login")
  public ResponseEntity<Void> login(@RequestBody LoginUserDTO user, HttpServletResponse response) {
    UserCredential userCredential = authenticationService.login(user.getEnterpriseCode(),
        user.getUsername(),
        user.getPassword()
    );

    final int ttl = 60 * 60;
    String jwt = tokenService.createJwt(userCredential.getUserId(), ttl);
    final Cookie cookie = new Cookie(this.authCookie, jwt);
    cookie.setHttpOnly(true);
    cookie.setMaxAge(ttl);
    response.addCookie(cookie);

    return ResponseEntity.ok().build();
  }

  /**
   * 注销.
   *
   * @param request request对象
   * @return ResponseEntity
   * @throws Exception 异常
   */
  @RequestMapping(method = RequestMethod.POST, value = "/logout")
  public ResponseEntity<Void> logout(HttpServletRequest request) throws Exception {
    try {
      HttpSession session = request.getSession();
      session.removeAttribute(OnlineManager.KEY_SYSTEM_SECURITY_CURRENT_USER_ID);
      session.invalidate();
    } catch (Exception e) {
      throw new BusinessException("注销失败");
    }
    return ResponseEntity.ok().build();
  }
}
