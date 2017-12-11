package bz.sunlight.service;

import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.vo.CurrentUserVO;
import bz.sunlight.vo.LoginUser;
import bz.sunlight.vo.ResultWithPagination;
import bz.sunlight.vo.UserVO;

public interface UserService {

  void save(SaveUserDTO userDTO, LoginUser loginUser);

  void disable(String id, LoginUser loginUser);

  void enable(String id, LoginUser loginUser);

  void edit(String id, SaveUserDTO userDTO, LoginUser loginUser);

  UserVO getUser(String id);

  ResultWithPagination<UserVO> getUsers(UserSearchDTO userSearchDTO);

  LoginUser getUserById(String userId);

  CurrentUserVO getCurrentUser(LoginUser user);
}
