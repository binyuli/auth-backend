package bz.sunlight.service.impl;

import bz.sunlight.dao.RoleMapper;
import bz.sunlight.dto.RoleDTO;
import bz.sunlight.entity.Role;
import bz.sunlight.mapstruct.RoleMapStruct;
import bz.sunlight.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  private RoleMapper roleMapper;
  @Autowired
  private RoleMapStruct roleMapStruct;

  @Override
  public List<RoleDTO> getRoles() {
    List<Role> roles = roleMapper.selectByExample(null);
    List<RoleDTO> rolesDTO = roleMapStruct.entityToDTO(roles);
    return rolesDTO;
  }
}
