package bz.sunlight.api;

import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController extends BaseContext {

  @Autowired
  private UserService userService;

  /**
   * 新增用户.
   */
  @PostMapping(value = "/users")
  public ResponseEntity<ResultInfo> add(@RequestBody SaveUserDTO userDTO) {
    userService.save(userDTO,createCommonDTO());
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
