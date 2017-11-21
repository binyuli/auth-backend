package bz.sunlight.service;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.vo.CurrentUserVO;
import bz.sunlight.vo.LoginUser;
import bz.sunlight.vo.ResultWithPagination;
import bz.sunlight.vo.UserVO;

public interface UserService {

  public void save(SaveUserDTO userDTO, CommonDTO commonDTO);

  public void disable(String id);

  public void enable(String id);

  public void edit(String id,SaveUserDTO userDTO);

  public UserVO getUser(String id);

  ResultWithPagination<UserVO> getUsers(UserSearchDTO userSearchDTO);

  public CurrentUserVO getCurrentUser(LoginUser loginUser);
}
