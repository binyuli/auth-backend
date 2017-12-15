package bz.sunlight.service.impl;

import bz.sunlight.dao.ApiMapper;
import bz.sunlight.dao.WhiteListMapper;
import bz.sunlight.entity.Api;
import bz.sunlight.entity.ApiExample;
import bz.sunlight.entity.WhiteList;
import bz.sunlight.service.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class AuthorizationServiceImpl implements Authorization {


  private ApiMapper apiMapper;
  private WhiteListMapper whiteListMapper;

  @Autowired
  public AuthorizationServiceImpl(ApiMapper apiMapper, WhiteListMapper whiteListMapper) {
    this.apiMapper = apiMapper;
    this.whiteListMapper = whiteListMapper;
  }

  @Override
  public boolean isAuthorized(String httpMethod, String url, String userId) {
    Api api = getApiByMehtodUrl(httpMethod, url);
    if (api != null) {
      // 判断api是否在白名单中
      WhiteList whiteList = whiteListMapper.selectByPrimaryKey(api.getId());
      if (whiteList != null) {
        return true;
      }
      // 否则，判断是否有权限
      int resultCount = calcApiByUser(userId, api.getId());
      if (resultCount != 0) {
        return true;
      }
    }

    return false;
  }

  private Api getApiByMehtodUrl(String httpMethod, String url) {
    ApiExample example = new ApiExample();
    //TODO Method 大小写区分
    example.createCriteria().andHttpMethodEqualTo(httpMethod);
    List<Api> apis = apiMapper.selectByExample(example);
    List<Api> results = apis.stream().filter(api -> api.getUrl().equals(url)).collect(Collectors.toList());
    if (results != null && results.size() > 0) {
      return results.get(0);
    }
    results = apis.stream().filter(api -> Pattern.matches(api.getUrl(), url)).collect(Collectors.toList());
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
