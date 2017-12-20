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
   * JWT 签名密钥.
   */
  @Value("${security.oauth2.resource.jwt.key-value}")
  public String jwtKeyValue;

  @Value("${spring.application.name}")
  public String applicationName;

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

  /**
   * 构造 OpenTracing 跟踪器.
   *
   * @return 跟踪器实例
   */
  @Bean
  public io.opentracing.Tracer jaegerTracer() {
    return new com.uber.jaeger.Configuration(applicationName,
        com.uber.jaeger.Configuration.SamplerConfiguration.fromEnv(),
        com.uber.jaeger.Configuration.ReporterConfiguration.fromEnv()).getTracer();
  }
}
