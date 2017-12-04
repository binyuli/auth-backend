package bz.sunlight.dao;

import bz.sunlight.entity.UserCredential;
import org.apache.ibatis.annotations.Param;

public interface UserCredentialMapper {
  UserCredential findByEnterpriseCodeAndUsername(@Param("enterpriseCode") String enterpriseCode,
                                                 @Param("username") String username);
}
