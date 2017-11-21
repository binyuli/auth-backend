package bz.sunlight.service;

import bz.sunlight.vo.LoginUser;

public interface AuthorizationService {

  boolean isAuthorized(String httpMethod, String url, LoginUser user);

}
