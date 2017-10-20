package bz.sunlight.service.impl;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dao.RoleMapper;
import bz.sunlight.dto.RoleDTO;
import bz.sunlight.entity.Role;
import bz.sunlight.entity.RoleExample;
import bz.sunlight.mapstruct.RoleMapStruct;
import bz.sunlight.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
  @Override
  public void abandon(String id) {
    Role role = new Role();
    role.setStatus(BaseConstant.BASEDATA_STATUS_ABANDON);
    RoleExample roleExample = new RoleExample();
    roleExample.createCriteria().andIdEqualTo(id);
    roleMapper.updateByExampleSelective(role, roleExample);
  }

  @Transactional
  @Override
  public void editRoleInfo(String id, String name) {
    Role role = new Role();
    role.setName(name);
    RoleExample roleExample = new RoleExample();
    roleExample.createCriteria().andIdEqualTo(id);
    roleMapper.updateByExampleSelective(role, roleExample);
  }
}
