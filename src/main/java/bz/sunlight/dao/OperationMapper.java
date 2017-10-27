package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.entity.Operation;
import bz.sunlight.entity.OperationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationMapper extends BaseMapper<Operation, OperationExample, String> {
  List<Operation> getOperationByRole(@Param("roleId") String roleId);

  List<Operation> getOperationByUserPage(@Param("userId") String userId, @Param("pageId") String pageId);
}