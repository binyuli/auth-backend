package bz.sunlight.api;

import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.service.UserService;
import bz.sunlight.vo.LoginUser;
import bz.sunlight.vo.ResultWithPagination;
import bz.sunlight.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
  public ResponseEntity<ResultInfo> add(@RequestBody SaveUserDTO userDTO, @RequestHeader("X-USER-ID") String userId) {
    userService.save(userDTO, getLoginUser(userId));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  /**
   * 冻结用户.
   *
   * @param id 用户Id
   * @return void
   */
  @PutMapping(value = "/users/{id}/disable")
  public ResponseEntity<Void> disable(@PathVariable String id, @RequestHeader("X-USER-ID") String userId) {
    userService.disable(id, getLoginUser(userId));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 解冻用户.
   *
   * @param id 用户Id
   * @return void
   */
  @PutMapping(value = "/users/{id}/enable")
  public ResponseEntity<Void> enable(@PathVariable String id, @RequestHeader("X-USER-ID") String userId) {
    userService.enable(id, getLoginUser(userId));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /**
   * 修改用户.
   *
   * @param id          用户Id
   * @param editUserDTO 用户信息
   * @return void
   */
  @PutMapping(value = "/users/{id}")
  public ResponseEntity<Void> edit(@PathVariable String id, @RequestBody SaveUserDTO editUserDTO,
                                   @RequestHeader("X-USER-ID") String userId) {
    userService.edit(id, editUserDTO, getLoginUser(userId));
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  /**
   * 根据条件查询用户信息.
   *
   * @param userSearchDTO 查询条件
   * @return userVO list
   */
  @GetMapping(value = "/users")
  public ResponseEntity<ResultInfo> getUsers(UserSearchDTO userSearchDTO, @RequestHeader("X-USER-ID") String userId) {
    LoginUser user = getLoginUser(userId);
    // 传入当前登录用户的企业Id
    userSearchDTO.setEnterpriseId(user.getEnterpriseId());
    ResultWithPagination<UserVO> usersResult = userService.getUsers(userSearchDTO);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, usersResult));
  }

  /**
   * 获取用户详细信息.
   *
   * @param id 用户Id
   * @return ResultInfo.
   */
  @GetMapping(value = "/users/{id}")
  public ResponseEntity<ResultInfo> getUserDetails(@PathVariable String id) {
    UserVO userVO = userService.getUser(id);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, userVO));
  }

  /**
   * 获取当前登录用户的信息.
   *
   * @param userId 用户Id
   * @return ResultInfo
   */
  @GetMapping(value = "/users/me")
  public ResponseEntity<ResultInfo> getCurrentUser(@RequestHeader(value = "X-USER-ID") String userId) {
    LoginUser user = getLoginUser(userId);
    return ResponseEntity.status(HttpStatus.OK).body(buildResultInfo(null, userService.getCurrentUser(user)));
  }
}
