package bz.sunlight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务配置.
 */
@Configuration
public class ApplicationConfiguration {
  private final DefaultAuthorizationFilter authFilter;

  @Autowired
  public ApplicationConfiguration(DefaultAuthorizationFilter authFilter) {
    this.authFilter = authFilter;
  }

  /**
   * 仅针对 /api/ 路径下的资源进行身份验证与权限检查.
   *
   * @return Filter 默认实现
   */
  @Bean
  public FilterRegistrationBean authApiFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(authFilter);
    registration.addUrlPatterns("/api/*");
    return registration;
  }
}

