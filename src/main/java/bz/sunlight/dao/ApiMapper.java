package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.entity.Api;
import bz.sunlight.entity.ApiExample;
import org.apache.ibatis.annotations.Param;

public interface ApiMapper extends BaseMapper<Api, ApiExample, String> {

  int countByOperationApi(@Param("userId") String userId, @Param("apiId") String apiId);

  int countByPageApi(@Param("userId") String userId, @Param("apiId") String apiId);

}