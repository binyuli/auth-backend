package bz.sunlight.mapstruct;

import bz.sunlight.dto.RoleDTO;
import bz.sunlight.dto.SaveRoleDTO;
import bz.sunlight.entity.Role;
import bz.sunlight.vo.RoleVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapStruct {

  List<RoleDTO> entityToDTOList(List<Role> roles);

  List<RoleVO> dtoToVOList(List<RoleDTO> roles);

  Role dtoToEntity(SaveRoleDTO saveRoleDTO);

  RoleDTO entityToDTO(Role role);

  RoleVO dtoToVO(RoleDTO roleDTO);
}
