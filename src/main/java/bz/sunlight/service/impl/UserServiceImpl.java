package bz.sunlight.service.impl;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dao.UserMapper;
import bz.sunlight.dao.UserRoleMapper;
import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.entity.User;
import bz.sunlight.entity.UserExample;
import bz.sunlight.entity.UserRole;
import bz.sunlight.entity.UserRoleExample;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.mapstruct.UserMapStruct;
import bz.sunlight.service.UserService;
import bz.sunlight.utils.BeanUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserRoleMapper userRoleMapper;
  @Autowired
  private UserMapStruct userMapStruct;


  @Transactional
  @Override
  public void save(SaveUserDTO userDTO, CommonDTO commonDTO) {

    //验证用户名是否重复
    UserExample userExample = new UserExample();
    userExample.createCriteria().andUsernameEqualTo(userDTO.getUsername());
    List<User> users = userMapper.selectByExample(userExample);
    if (users != null && users.size() > 0) {
      //TODO 异常的错误码待整理调整
      throw new BusinessException("用户名已经存在");
    }
    User user = null;
    if (userDTO != null) {
      user = userMapStruct.dtoToEntity(userDTO);
    }
    //填充公共信息 e.g 创建时间 创建人等
    BeanUtilsHelper.copyPropertiesWithRuntimeException(user, commonDTO);
    user.setId(UUID.randomUUID().toString());
    user.setStatus(BaseConstant.BASEDATA_STATUS_VALID);
    userMapper.insert(user);
    List<String> roles = userDTO.getRoles();
    for (String roleId : roles) {
      UserRole userRole = new UserRole();
      userRole.setRoleId(roleId);
      userRole.setUserId(user.getId());
      userRoleMapper.insert(userRole);
    }
  }

  @Transactional
  @Override
  public void disable(String id) {
    User user = new User();
    user.setStatus(BaseConstant.USER_STATUS_DISABLE);
    UserExample userExample = new UserExample();
    userExample.createCriteria().andIdEqualTo(id);
    userMapper.updateByExampleSelective(user, userExample);
  }

  @Transactional
  @Override
  public void enable(String id) {
    User user = new User();
    user.setStatus(BaseConstant.USER_STATUS_ENABLE);
    UserExample userExample = new UserExample();
    userExample.createCriteria().andIdEqualTo(id);
    userMapper.updateByExampleSelective(user, userExample);
  }

  @Override
  public void edit(String id, SaveUserDTO userDTO) {
    User user = userMapStruct.dtoToEntity(userDTO);
    UserExample userExample = new UserExample();
    userExample.createCriteria().andIdEqualTo(id);
    userMapper.updateByExampleSelective(user, userExample);

    UserRoleExample userRoleExample = new UserRoleExample();
    userRoleExample.createCriteria().andUserIdEqualTo(id);
    userRoleMapper.deleteByExample(userRoleExample);
    addeUser(userDTO, id);
  }

  private void addeUser(SaveUserDTO userDTO, String userId) {
    List<String> roles = userDTO.getRoles();
    if (roles != null && roles.size() > 0) {
      for (String role : roles) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(role);
        userRoleMapper.insert(userRole);
      }
    }
  }

}
