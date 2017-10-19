package bz.sunlight.service.impl;

import bz.sunlight.dao.UserMapper;
import bz.sunlight.dao.UserRoleMapper;
import bz.sunlight.dto.AddUserDTO;
import bz.sunlight.entity.User;
import bz.sunlight.entity.UserExample;
import bz.sunlight.entity.UserRole;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.mapstruct.UserMapStruct;
import bz.sunlight.service.AbstractBaseService;
import bz.sunlight.service.UserService;
import bz.sunlight.utils.BeanUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserRoleMapper userRoleMapper;
  @Autowired
  private UserMapStruct userMapStruct;

  @Transactional
  @Override
  public void save(AddUserDTO userDTO) {

    //验证用户名是否重复
    UserExample userExample = new UserExample();
    userExample.createCriteria().andUsernameEqualTo(userDTO.getUsername());
    List<User> users = userMapper.selectByExample(userExample);
    if (users != null && users.size() > 0) {
      //TODO 异常的错误码待整理调整
      throw new BusinessException("F01","用户名已经存在");
    }
    User user = null;
    if (userDTO != null) {
      user = userMapStruct.dtoToEntity(userDTO);
    }
    //填充公共信息 e.g 创建时间 创建人等
    BeanUtilsHelper.copyPropertiesWithRuntimeException(user, createCommonDTO());
    user.setId(UUID.randomUUID().toString());
    user.setStatus(0);
    userMapper.insert(user);
    List<String> roles = userDTO.getRoles();
    for (String roleId : roles) {
      UserRole userRole = new UserRole();
      userRole.setRoleId(roleId);
      userRole.setUserId(user.getId());
      userRoleMapper.insert(userRole);
    }
  }
}
