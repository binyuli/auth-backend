package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.entity.Api;
import bz.sunlight.entity.ApiExample;
import org.apache.ibatis.annotations.Param;

public interface ApiMapper extends BaseMapper<Api, ApiExample, String> {

  long countByOperationApi(@Param("userId") String userId, @Param("apiId") String apiId);

  long countByPageApi(@Param("userId") String userId, @Param("apiId") String apiId);

}