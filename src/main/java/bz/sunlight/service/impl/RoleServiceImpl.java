package bz.sunlight.service.impl;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dao.CommonMapper;
import bz.sunlight.dao.PermissionMapper;
import bz.sunlight.dao.RoleMapper;
import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.RoleDTO;
import bz.sunlight.dto.SaveRoleDTO;
import bz.sunlight.entity.Permission;
import bz.sunlight.entity.PermissionExample;
import bz.sunlight.entity.Role;
import bz.sunlight.entity.RoleExample;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.mapstruct.RoleMapStruct;
import bz.sunlight.service.RoleService;
import bz.sunlight.utils.BeanUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  private RoleMapper roleMapper;
  @Autowired
  private PermissionMapper permissionMapper;
  @Autowired
  private RoleMapStruct roleMapStruct;
  @Autowired
  private CommonMapper commonMapper;

  @Override
  public RoleDTO getRole(String id) {
    return roleMapStruct.entityToDTO(roleMapper.selectByPrimaryKey(id));
  }

  @Override
  public List<RoleDTO> getRoles(Integer status, String enterpriseId) {
    RoleExample roleExample = new RoleExample();
    roleExample.createCriteria().andStatusEqualTo(status).andEnterpriseIdEqualTo(enterpriseId);
    List<Role> roles = roleMapper.selectByExample(roleExample);
    List<RoleDTO> rolesDTO = roleMapStruct.entityToDTOList(roles);
    return rolesDTO;
  }

  @Transactional
  @Override
  public void abandon(String id) {
    Role roleOrig = roleMapper.selectByPrimaryKey(id);
    if (roleOrig != null) {
      Role role = new Role();
      role.setStatus(BaseConstant.BASEDATA_STATUS_INVALID);
      RoleExample roleExample = new RoleExample();
      roleExample.createCriteria().andIdEqualTo(id).andRowVersionEqualTo(roleOrig.getRowVersion());
      int updateResult = roleMapper.updateByExampleSelective(role, roleExample);
      if (updateResult == 0) {
        throw new BusinessException("当前角色正在被其他用户修改");
      }
    }
  }

  @Transactional
  @Override
  public void editRoleInfo(String id, String name) {
    Role roleOrig = roleMapper.selectByPrimaryKey(id);
    if (roleOrig != null && !roleOrig.getName().equals(name)) {
      //角色名称 有变化则 检查重复并更新数据, 无变化则不做处理
      checkDuplicateRoleName(name);
      Role role = new Role();
      role.setName(name);
      RoleExample roleExample = new RoleExample();
      roleExample.createCriteria().andIdEqualTo(id).andRowVersionEqualTo(roleOrig.getRowVersion());
      int updateResult = roleMapper.updateByExampleSelective(role, roleExample);
      if (updateResult == 0) {
        throw new BusinessException("当前角色正在被其他用户修改");
      }
    }
  }

  @Transactional
  @Override
  public void save(SaveRoleDTO roleDTO, CommonDTO commonDTO) {
    checkDuplicateRoleName(roleDTO.getName());
    Role role = roleMapStruct.dtoToEntity(roleDTO);
    BeanUtilsHelper.copyPropertiesWithRuntimeException(role, commonDTO);
    role.setStatus(BaseConstant.BASEDATA_STATUS_VALID);
    role.setId(UUID.randomUUID().toString());
    roleMapper.insert(role);
    addPermission(roleDTO, role.getId());
  }

  private void checkDuplicateRoleName(String roleName) {
    RoleExample roleExample = new RoleExample();
    roleExample.createCriteria().andNameEqualTo(roleName);
    List<Role> roles = roleMapper.selectByExample(roleExample);
    if (roles != null && roles.size() > 0) {
      throw new BusinessException("角色名称已经存在");
    }
  }

  @Transactional
  @Override
  public void edit(String id, SaveRoleDTO roleDTO) {
    Role roleOrig = roleMapper.selectByPrimaryKey(id);
    if (roleOrig != null) {
      // 用户名如果未修改则不进行重名排查
      if (!roleDTO.getName().equals(roleOrig.getName())) {
        checkDuplicateRoleName(roleDTO.getName());
      }
      Role role = roleMapStruct.dtoToEntity(roleDTO);
      role.setRowVersion(commonMapper.now());
      RoleExample roleExample = new RoleExample();
      roleExample.createCriteria().andIdEqualTo(id).andRowVersionEqualTo(roleOrig.getRowVersion());
      int updateResult = roleMapper.updateByExampleSelective(role, roleExample);
      if (updateResult == 0) {
        throw new BusinessException("当前角色正在被其他用户修改");
      } else {
        //角色对应的page operation ,删除再插入新数据
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andRoleIdEqualTo(id)
            .andTypeIn(Arrays.asList(BaseConstant.PERMISSION_TYPE_PAGE, BaseConstant.PERMISSION_TYPE_OPERATION));
        permissionMapper.deleteByExample(permissionExample);
        addPermission(roleDTO, id);
      }
    }
  }

  private void addPermission(SaveRoleDTO roleDTO, String roleId) {
    List<String> operations = roleDTO.getOperations();
    if (operations != null && operations.size() > 0) {
      for (String operation : operations) {
        Permission permission = new Permission();
        permission.setRoleId(roleId);
        permission.setRelatedId(operation);
        permission.setType(BaseConstant.PERMISSION_TYPE_OPERATION);
        permissionMapper.insert(permission);
      }
    }
    List<String> pages = roleDTO.getPages();
    if (pages != null && pages.size() > 0) {
      for (String page : pages) {
        Permission permission = new Permission();
        permission.setRoleId(roleId);
        permission.setRelatedId(page);
        permission.setType(BaseConstant.PERMISSION_TYPE_PAGE);
        permissionMapper.insert(permission);
      }
    }
  }
}
