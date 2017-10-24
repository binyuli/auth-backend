package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.dto.UserSearchDTO;
import bz.sunlight.entity.User;
import bz.sunlight.entity.UserExample;

import java.util.List;

public interface UserMapper extends BaseMapper<User, UserExample, String> {

  Integer countByRoles(UserSearchDTO userSearchDTO);

  List<User> selectByPagination(UserSearchDTO userSearchDTO);
}