package bz.sunlight.api;

import bz.sunlight.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class AuthController extends BaseContext {

  @Autowired
  private AuthService authService;

  /**
   * api访问权限校验.
   *
   * @return ResponseEntity
   */
  @PostMapping(value = "/auth")
  public ResponseEntity<Void> checkAccessAuthority(@RequestHeader(value = "X-Original-Method") String httpMethod,
                                                   @RequestHeader(value = "X-Original-URI") String url) {
    LoginUser loginUser = this.getLoginUser();
    if (loginUser != null) {
      if (authService.isAccessible(httpMethod, url, loginUser.getId())) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    if (authorizationService.isAuthorized(httpMethod, url, loginUser)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
  }

}
