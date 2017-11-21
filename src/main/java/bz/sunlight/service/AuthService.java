package bz.sunlight.service;

public interface AuthorizationService {

  boolean isAuthorized(String httpMethod, String url, String userId);

}
