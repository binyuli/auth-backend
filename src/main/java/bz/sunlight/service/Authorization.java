package bz.sunlight.service;

import bz.sunlight.vo.LoginUser;

import javax.servlet.http.HttpServletRequest;

public interface Authorization {

  boolean isAuthorized(String httpMethod, String url, LoginUser user);
  boolean isAuthorized(HttpServletRequest request, LoginUser user);
}
