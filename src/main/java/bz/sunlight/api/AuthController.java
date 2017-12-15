package bz.sunlight.api;

import bz.sunlight.auth.DefaultTokenService;
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
import java.net.URI;
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
   * 进行身份验证及权限校验.
   * <p>全部通过则返回 200，并包含 X-USER-ID 自定义头部；身份验证失败则返回 401，权限校验失败则返回 403.</p>
   *
   * @return Response
   */
  @RequestMapping(value = "/auth")
  public ResponseEntity<Void> isAuthorized(@RequestHeader(value = "X-Original-Method") String httpMethod,
                                           @RequestHeader(value = "X-Original-URI") String url,
                                           HttpServletRequest request) {
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
   * 使用企业编号、用户名和密码登录，认证成功则在 Response 中包含身份凭据的 Cookie.
   *
   * @param user     认证信息
   * @param response Response 对象
   * @return Response
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
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    cookie.setMaxAge(ttl);
    response.addCookie(createAuthCookie(jwt, ttl));

    return ResponseEntity.ok().build();
  }

  /**
   * 注销，注销成功则在 Response 中清除身份凭据的 Cookie.
   *
   * @param response Response 对象
   * @return Response
   */
  @RequestMapping(method = RequestMethod.POST, value = "/logout")
  public ResponseEntity<Void> logout(HttpServletResponse response) {
    response.addCookie(createAuthCookie("", -1));

    return ResponseEntity.ok().build();
  }

  /**
   * 生成身份凭据的 Cookie.
   *
   * @param value 身份凭据
   * @param ttl   有效期，以秒为单位
   * @return Cookie 对象
   */
  private Cookie createAuthCookie(String value, int ttl) {
    final Cookie cookie = new Cookie(this.authCookie, value);
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    cookie.setMaxAge(ttl);
    return cookie;
  }
}
