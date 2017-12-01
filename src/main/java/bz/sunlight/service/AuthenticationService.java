package bz.sunlight.service;

import bz.sunlight.entity.UserCredential;

/**
 * 身份验证服务
 */
public interface AuthenticationService {
  /**
   * 登录
   *
   * @param enterpriseCode 企业编号
   * @param username       用户名
   * @param password       密码
   * @return 成功登录的用户信息
   */
  UserCredential login(String enterpriseCode, String username, String password);

}
