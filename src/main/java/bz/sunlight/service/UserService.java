package bz.sunlight.service;

import bz.sunlight.api.BaseContext;
import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.dto.UserDTO;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.vo.ResultWithPagination;
import bz.sunlight.vo.UserVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

  public void save(SaveUserDTO userDTO, CommonDTO commonDTO);

  public void disable(String id);

  public void enable(String id);

  public void edit(String id,SaveUserDTO userDTO);

  ResultWithPagination<UserVO> getUsers(UserSearchDTO userSearchDTO);

}
