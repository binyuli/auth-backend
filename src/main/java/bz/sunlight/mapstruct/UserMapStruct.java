package bz.sunlight.mapstruct;

import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.dto.UserDTO;
import bz.sunlight.entity.User;
import bz.sunlight.vo.CurrentUserVO;
import bz.sunlight.vo.LoginUser;
import bz.sunlight.vo.UserVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

  User dtoToEntity(SaveUserDTO userDTO);

  List<UserDTO> entityToDTO(List<User> users);

  List<UserVO> dtoToVO(List<UserDTO> userDTOList);

  UserVO singleDtoToVO(UserDTO userDTO);

  UserDTO singleEntityToDTO(User user);

  CurrentUserVO loginUserToCurrent(LoginUser loginUser);
}
