package bz.sunlight.service;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.entity.User;
import bz.sunlight.vo.CurrentUserVO;
import bz.sunlight.vo.ResultWithPagination;
import bz.sunlight.vo.UserVO;

public interface UserService {

  void save(SaveUserDTO userDTO, CommonDTO commonDTO);

  void disable(String id);

  void enable(String id);

  void edit(String id, SaveUserDTO userDTO);

  UserVO getUser(String id);

  ResultWithPagination<UserVO> getUsers(UserSearchDTO userSearchDTO);

  User getUserById(String userId);

  CurrentUserVO getCurrentUser(String userId);
}
