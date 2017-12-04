package bz.sunlight.service.impl;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dao.UserCredentialMapper;
import bz.sunlight.entity.UserCredential;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
      throw new BusinessException("", String.format("企业或账号不存在！ %s, %s", enterpriseCode, username));
    }
    if (userCredential.getStatus() == BaseConstant.BASEDATA_STATUS_INVALID) {
      throw new BusinessException("", String.format("用户已冻结！ %s, %s", enterpriseCode, username));
    }
    BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
    if (!passwordEncoder.matches(password, userCredential.getPassword())) {
      throw new BusinessException("", String.format("登录密码不正确！ %s, %s", enterpriseCode, username));
    }
    return userCredential;
  }
}
