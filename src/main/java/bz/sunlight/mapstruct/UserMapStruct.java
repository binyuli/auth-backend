package bz.sunlight.mapstruct;

import bz.sunlight.dto.AddUserDTO;
import bz.sunlight.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

  User dtoToEntity(AddUserDTO userDTO);
}
