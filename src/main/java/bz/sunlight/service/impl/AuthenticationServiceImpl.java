package bz.sunlight.service.impl;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dao.UserCredentialMapper;
import bz.sunlight.entity.UserCredential;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  private UserCredentialMapper userCredentialMapper;

  @Autowired
  public AuthenticationServiceImpl(UserCredentialMapper userCredentialMapper) {
    this.userCredentialMapper = userCredentialMapper;
  }

  @Override
  public UserCredential login(String enterpriseCode, String username, String password) {
    UserCredential userCredential = userCredentialMapper.findByEnterpriseCodeAndUsername(enterpriseCode, username);
    if (userCredential == null) {
      throw new BusinessException("", "企业或用户名不存在！");
    }
    if (userCredential.getStatus() == BaseConstant.BASEDATA_STATUS_INVALID) {
      throw new BusinessException("", "用户已冻结！");
    }
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    if (!passwordEncoder.matches(password, userCredential.getPassword())) {
      throw new BusinessException("", "登录密码不正确！");
    }
    return userCredential;
  }
}
