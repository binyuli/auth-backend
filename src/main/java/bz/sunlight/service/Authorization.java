package bz.sunlight.service;

public interface Authorization {

  boolean isAuthorized(String httpMethod, String url, String userId);
}
