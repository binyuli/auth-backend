package bz.sunlight.mapstruct;

import java.util.List;

import bz.sunlight.dto.RoleDTO;
import bz.sunlight.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapStruct {
  List<RoleDTO> entityToDTO(List<Role> roles);
}
