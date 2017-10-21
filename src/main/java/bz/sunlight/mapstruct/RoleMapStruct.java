package bz.sunlight.mapstruct;

import bz.sunlight.dto.RoleDTO;
import bz.sunlight.entity.Role;
import bz.sunlight.vo.RoleVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapStruct {
  
  List<RoleDTO> entityToDTO(List<Role> roles);

  List<RoleVO> dtoToVO(List<RoleDTO> roles);
}
