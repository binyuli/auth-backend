package bz.sunlight.service.impl;

import bz.sunlight.dao.ApiMapper;
import bz.sunlight.entity.Api;
import bz.sunlight.entity.ApiExample;
import bz.sunlight.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private ApiMapper apiMapper;

  @Override
  public boolean isAccessible(String httpMethod, String url) {
    ApiExample example = new ApiExample();
    example.createCriteria().andHttpMethodEqualTo(httpMethod).andUrlEqualTo(url);
    List<Api> apiList = apiMapper.selectByExample(example);
    if (apiList.size() != 0) {
      return true;
    } else {
      return false;
    }
  }

}
