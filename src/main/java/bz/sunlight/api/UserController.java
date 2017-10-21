package bz.sunlight.api;

import bz.sunlight.dto.AddUserDTO;
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
public class UserController extends BaseController {

  @Autowired
  private UserService userService;

  /**
   * 新增用户.
   */
  @PostMapping(value = "/users")
  public ResponseEntity<ResultInfo> addUser(@RequestBody AddUserDTO userDTO) {
    userService.save(userDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
