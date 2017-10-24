package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.entity.Role;
import bz.sunlight.entity.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role, RoleExample, String> {

  List<Role> selectByUserId(@Param("userId") String userId);
}