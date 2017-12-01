package bz.sunlight.service;

import bz.sunlight.vo.LoginUser;

import javax.servlet.http.HttpServletRequest;

public interface Authorization {

  boolean isAuthorized(String httpMethod, String url, String userId);

  boolean isAuthorized(HttpServletRequest request, String userId);
}
