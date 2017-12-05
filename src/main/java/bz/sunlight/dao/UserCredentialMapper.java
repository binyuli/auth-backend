package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.entity.UserCredential;
import bz.sunlight.entity.UserCredentialExample;
import org.apache.ibatis.annotations.Param;

public interface UserCredentialMapper extends BaseMapper<UserCredential, UserCredentialExample, String> {
  UserCredential findByEnterpriseCodeAndUsername(@Param("enterpriseCode") String enterpriseCode,
                                                 @Param("username") String username);
}
