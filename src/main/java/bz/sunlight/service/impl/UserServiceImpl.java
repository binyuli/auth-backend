package bz.sunlight.service.impl;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dao.CommonMapper;
import bz.sunlight.dao.RoleMapper;
import bz.sunlight.dao.UserMapper;
import bz.sunlight.dao.UserRoleMapper;
import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.SaveUserDTO;
import bz.sunlight.dto.UserDTO;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.entity.Role;
import bz.sunlight.entity.User;
import bz.sunlight.entity.UserExample;
import bz.sunlight.entity.UserRole;
import bz.sunlight.entity.UserRoleExample;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.handler.PageHelper;
import bz.sunlight.mapstruct.UserMapStruct;
import bz.sunlight.service.UserService;
import bz.sunlight.utils.BeanUtilsHelper;
import bz.sunlight.vo.ResultWithPagination;
import bz.sunlight.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserRoleMapper userRoleMapper;
  @Autowired
  private UserMapStruct userMapStruct;
  @Autowired
  private RoleMapper roleMapper;
  @Autowired
  private CommonMapper commonMapper;

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
    updateUserStatus(id, BaseConstant.BASEDATA_STATUS_INVALID);
  }

  @Transactional
  @Override
  public void enable(String id) {
    updateUserStatus(id, BaseConstant.BASEDATA_STATUS_VALID);
  }

  private void updateUserStatus(String id, int status) {
    User userOrig = userMapper.selectByPrimaryKey(id);
    if (userOrig != null) {
      User user = new User();
      user.setRowVersion(commonMapper.now());
      user.setStatus(status);
      UserExample userExample = new UserExample();
      userExample.createCriteria().andIdEqualTo(id).andRowVersionEqualTo(userOrig.getRowVersion());
      int updateResult = userMapper.updateByExampleSelective(user, userExample);
      if (updateResult == 0) {
        throw new BusinessException("当前用户正在被其他操作修改");
      }
    }
  }

  @Transactional
  @Override
  public void edit(String id, SaveUserDTO userDTO) {
    User userOrig = userMapper.selectByPrimaryKey(id);
    if (userOrig != null) {
      User user = userMapStruct.dtoToEntity(userDTO);
      user.setRowVersion(commonMapper.now());
      UserExample userExample = new UserExample();
      userExample.createCriteria().andIdEqualTo(id).andRowVersionEqualTo(userOrig.getRowVersion());
      int updateResult = userMapper.updateByExampleSelective(user, userExample);
      if (updateResult == 0) {
        throw new BusinessException("当前用户正在被其他操作修改");
      } else {
        handleRelation(userDTO, id);
      }
    }
  }

  private void handleRelation(SaveUserDTO userDTO, String userId) {
    UserRoleExample userRoleExample = new UserRoleExample();
    userRoleExample.createCriteria().andUserIdEqualTo(userId);
    userRoleMapper.deleteByExample(userRoleExample);

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

  @Override
  public ResultWithPagination<UserVO> getUsers(UserSearchDTO userSearchDTO) {
    ResultWithPagination usersResult = new ResultWithPagination();

    // check page info
    if (userSearchDTO.getPageSize() != null && userSearchDTO.getPageSize() >= BaseConstant.MINIMUM_PAGE_SIZE) {
      usersResult.setPageSize(userSearchDTO.getPageSize());
    } else {
      userSearchDTO.setPageSize(BaseConstant.DEFAULT_PAGE_SIZE);
    }
    if (userSearchDTO.getPageIndex() != null && userSearchDTO.getPageIndex() >= BaseConstant.MINIMUM_PAGE_INDEX) {
      usersResult.setPageIndex(userSearchDTO.getPageIndex());
    } else {
      userSearchDTO.setPageIndex(BaseConstant.DEFAULT_PAGE_INDEX);
    }

    // check sort
    if (StringUtils.isBlank(userSearchDTO.getSortField())) {
      userSearchDTO.setSortField(BaseConstant.DEFAULT_SORT_FIELD);
    }
    if (userSearchDTO.getIsDesc() != null && userSearchDTO.getIsDesc()) {
      usersResult.setSort(BaseConstant.DESCENDING_SORT_TYPE);
    } else {
      usersResult.setSort(BaseConstant.ASCENDING_SORT_TYPE);
    }

    // get counts
    Integer totalElements = userMapper.countByRoles(userSearchDTO);
    Integer totalPages = PageHelper.getTotalPage(totalElements, userSearchDTO.getPageSize());
    usersResult.setTotalElements(totalElements);
    usersResult.setTotalPages(totalPages);

    // get users
    userSearchDTO.setOffset(PageHelper.toOffset(userSearchDTO.getPageIndex() + 1, userSearchDTO.getPageSize()));
    List<User> users = userMapper.selectByPagination(userSearchDTO);

    // inject roles
    List<UserDTO> userDTOList = userMapStruct.entityToDTO(users);
    List<UserVO> userVOList = userMapStruct.dtoToVO(userDTOList);
    for (UserVO userVO : userVOList) {
      List<Role> roleList = roleMapper.selectByUserId(userVO.getId());
      userVO.setRoles(makeRoleMapList(roleList));
    }
    usersResult.setContent(userVOList);

    return usersResult;
  }

  @Override
  public UserVO getUser(String id) {
    UserDTO userDTO = userMapStruct.singleEntityToDTO(userMapper.selectByPrimaryKey(id));
    if (userDTO != null) {
      UserVO userVO = userMapStruct.singleDtoToVO(userDTO);

      // inject roles
      List<Role> roleList = roleMapper.selectByUserId(userVO.getId());
      userVO.setRoles(makeRoleMapList(roleList));

      return userVO;
    } else {
      return null;
    }
  }

  private List<Map<String, String>> makeRoleMapList(List<Role> roleList) {
    List<Map<String, String>> roleMapList = new ArrayList<>();
    for (Role role : roleList) {
      Map<String, String> roleMap = new HashMap<>();
      roleMap.put("id", role.getId());
      roleMap.put("name", role.getName());
      roleMapList.add(roleMap);
    }
    return roleMapList;
  }

}
