package bz.sunlight.service;

public interface AuthService {

  boolean isAccessible(String httpMethod, String url);

}
