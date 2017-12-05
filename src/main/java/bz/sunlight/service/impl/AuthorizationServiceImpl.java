package bz.sunlight.service.impl;

import bz.sunlight.dao.ApiMapper;
import bz.sunlight.dao.UserMapper;
import bz.sunlight.entity.Api;
import bz.sunlight.entity.ApiExample;
import bz.sunlight.entity.User;
import bz.sunlight.service.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class AuthorizationServiceImpl implements Authorization {


  private ApiMapper apiMapper;
  private UserMapper userMapper;

  @Autowired
  public AuthorizationServiceImpl(ApiMapper apiMapper, UserMapper userMapper) {
    this.apiMapper = apiMapper;
    this.userMapper = userMapper;
  }

  @Override
  public boolean isAuthorized(String httpMethod, String url, String userId) {
    StopWatch stopWatch = new StopWatch("isAuthorized");
    stopWatch.start("get api");
    User userInfo = userMapper.selectByPrimaryKey(userId);
    Api api = getApiByMehtodUrl(httpMethod, url, userInfo.getEnterpriseId());
    stopWatch.stop();
    System.out.println(stopWatch.prettyPrint());
    if (api != null) {
      stopWatch.start("calcApiByUser");
      int resultCount = calcApiByUser(userInfo.getId(), api.getId());
      stopWatch.stop();
      System.out.println(stopWatch.prettyPrint());
      if (resultCount != 0) {
        return true;
      }
    }

    return false;
  }

  private Api getApiByMehtodUrl(String httpMethod, String url, String enterpriseId) {
    ApiExample example = new ApiExample();
    //TODO Method 大小写区分
    example.createCriteria().andHttpMethodEqualTo(httpMethod).andEnterpriseIdEqualTo(enterpriseId);
    List<Api> apis = apiMapper.selectByExample(example);
    List<Api> results = apis.stream().filter(api -> Pattern.matches(api.getUrl(), url)).collect(Collectors.toList());
    if (results != null && results.size() > 0) {
      return results.get(0);
    }
    return null;
  }

  /**
   * 根据用户 api id 关联查询统计数量.
   *
   * @param userId 用户Id
   * @param apiId  api的Id
   * @return 用户与API的
   */
  private int calcApiByUser(String userId, String apiId) {
    return apiMapper.countByOperationApi(userId, apiId) + apiMapper.countByPageApi(userId, apiId);
  }
}
