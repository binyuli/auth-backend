package bz.sunlight.service.impl;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dao.EnterpriseMapper;
import bz.sunlight.dao.UserCredentialMapper;
import bz.sunlight.entity.Enterprise;
import bz.sunlight.entity.UserCredential;
import bz.sunlight.exception.BusinessException;
import bz.sunlight.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  private EnterpriseMapper enterpriseMapper;
  private UserCredentialMapper userCredentialMapper;
//  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public AuthenticationServiceImpl(EnterpriseMapper enterpriseMapper, UserCredentialMapper userCredentialMapper) {
    this.enterpriseMapper = enterpriseMapper;
    this.userCredentialMapper = userCredentialMapper;
//    this.passwordEncoder = passwordEncoder;
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
//    if(!passwordEncoder.matches(password, userCredential.getPassword()))
    if (!userCredential.getPassword().equals(password)) {
      throw new BusinessException("", String.format("登录密码不正确！ %s, %s,", enterpriseCode, username));
    }
    return userCredential;
  }
}
