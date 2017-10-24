package bz.sunlight.api;

import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.mapstruct.UserMapStruct;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.service.UserService;
import bz.sunlight.vo.ResultWithPagination;
import bz.sunlight.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController extends BaseContext {

  @Autowired
  private UserService userService;
  @Autowired
  private UserMapStruct userMapStruct;

  /**
   * 新增用户.
   */
  @PostMapping(value = "/users")
  public ResponseEntity<ResultInfo> add(@RequestBody SaveUserDTO userDTO) {
    userService.save(userDTO,createCommonDTO());
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  /**
   * 冻结用户.
   * @param id.
   * @return void.
   */
  @PutMapping(value = "/users/{id}/disable")
  public ResponseEntity<Void> disable(@PathVariable String id) {
    userService.disable(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 解冻用户.
   * @param id.
   * @return void.
   */
  @PutMapping(value = "/users/{id}/enable")
  public ResponseEntity<Void> enable(@PathVariable String id) {
    userService.enable(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 修改用户.
   *
   * @param id.
   * @param editUserDTO.
   * @return void
   */
  @PutMapping(value = "/users/{id}")
  public ResponseEntity<Void> edit(@PathVariable String id, @RequestBody SaveUserDTO editUserDTO) {
    userService.edit(id,editUserDTO);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  /**
   * 根据条件查询用户信息.
   * @return userVO list.
   */
  @GetMapping(value = "/users")
  public ResponseEntity<ResultInfo> getUsers(UserSearchDTO userSearchDTO) {
    ResultWithPagination<UserVO> usersResult = userService.getUsers(userSearchDTO);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, usersResult));
  }
}
