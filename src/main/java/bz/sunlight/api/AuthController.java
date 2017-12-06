package bz.sunlight.api;

import bz.sunlight.constant.OnlineManager;
import bz.sunlight.dto.LoginUserDTO;
import bz.sunlight.entity.UserCredential;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.service.AuthenticationService;
import bz.sunlight.service.Authorization;
import bz.sunlight.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/v1")
public class AuthController extends BaseContext {

  @Autowired
  private Authorization authorizationService;
  @Autowired
  private AuthenticationService authenticationService;

  /**
   * api访问权限校验.
   *
   * @return ResponseEntity
   */
  @PostMapping(value = "/auth")
  public ResponseEntity<Void> isAuthorized(@RequestHeader(value = "X-Original-Method") String httpMethod,
                                           @RequestHeader(value = "X-Original-URI") String url,
                                           HttpServletRequest request) {
    HttpSession session = request.getSession();
    Object userId = session.getAttribute(OnlineManager.KEY_SYSTEM_SECURITY_CURRENT_USER_ID);
    if (userId == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    LoginUser user = getLoginUser(userId.toString());
    if (authorizationService.isAuthorized(httpMethod, url, user.getId(), user.getEnterpriseId())) {
      return ResponseEntity.ok().header("X-USER-ID", userId.toString()).build();
    }
    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
  }

  /**
   * 登录.
   *
   * @param user    登录用户信息
   * @param request request对象
   * @return ResponseEntity
   * @throws Exception 异常
   */
  @RequestMapping(method = RequestMethod.POST, value = "/user/login")
  public ResponseEntity<Void> login(@RequestBody LoginUserDTO user,
                                    HttpServletRequest request) throws Exception {
    UserCredential userCredential = authenticationService.login(user.getEnterpriseCode(),
        user.getUsername(),
        user.getPassword()
    );
    HttpSession session = request.getSession();
    session.setAttribute(OnlineManager.KEY_SYSTEM_SECURITY_CURRENT_USER_ID, userCredential.getUserId());
    return ResponseEntity.ok().build();
  }

  /**
   * 注销.
   *
   * @param request request对象
   * @return ResponseEntity
   * @throws Exception 异常
   */
  @RequestMapping(method = RequestMethod.POST, value = "/user/logout")
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
