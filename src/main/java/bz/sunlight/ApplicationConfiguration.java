package bz.sunlight;

import bz.sunlight.auth.DefaultTokenService;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class ApplicationConfiguration {
  /**
   * JWT 签名密钥
   */
  @Value("${security.oauth2.resource.jwt.key-value}")
  public String jwtKeyValue;

  /**
   * 从配置文件中加载签名的密钥，并初始化 Token 服务.
   *
   * @return Token 服务实例
   */
  @Bean
  public DefaultTokenService tokenService() {
    SecretKeySpec key = new SecretKeySpec(jwtKeyValue.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    return new DefaultTokenService(key);
  }
}
