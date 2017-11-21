package bz.sunlight.service.impl;

import bz.sunlight.api.BaseContext;
import bz.sunlight.dao.ApiMapper;
import bz.sunlight.entity.Api;
import bz.sunlight.entity.ApiExample;
import bz.sunlight.service.AuthorizationService;
import bz.sunlight.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {


  private ApiMapper apiMapper;

  @Autowired
  public AuthorizationServiceImpl(ApiMapper apiMapper) {
    this.apiMapper = apiMapper;
  }

  @Override
  public boolean isAuthorized(String httpMethod, String url, LoginUser user) {
    StopWatch stopWatch = new StopWatch("isAuthorized");
    stopWatch.start("get api");
    Api api = getApiByMehtodUrl(httpMethod, url, user);
    stopWatch.stop();
    System.out.println(stopWatch.prettyPrint());
    if (api != null) {
      stopWatch.start("calcApiByUser");
      int resultCount = calcApiByUser(user.getId(), api.getId());
      stopWatch.stop();
      System.out.println(stopWatch.prettyPrint());
      if (resultCount != 0) {
        return true;
      }
    }

    return false;
  }

  private Api getApiByMehtodUrl(String httpMethod, String url, LoginUser loginUser) {
    ApiExample example = new ApiExample();
    //TODO Method 大小写区分
    example.createCriteria().andHttpMethodEqualTo(httpMethod).andEnterpriseIdEqualTo(loginUser.getEnterpriseId());
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
   * @param userId.
   * @param apiId.
   * @return 用户与API的
   */
  private int calcApiByUser(String userId, String apiId) {
    return apiMapper.countByOperationApi(userId, apiId) + apiMapper.countByPageApi(userId, apiId);
  }

}
