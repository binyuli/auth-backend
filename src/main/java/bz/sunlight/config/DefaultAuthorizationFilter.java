package bz.sunlight.config;

import bz.sunlight.api.BaseContext;
import bz.sunlight.service.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 身份验证与权限检查的默认实现
 */
@Component
public class DefaultAuthorizationFilter extends GenericFilterBean {
  private final Authorization authorization; // 权限检查服务

  @Autowired
  public DefaultAuthorizationFilter(Authorization authorization) {
    this.authorization = authorization;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
//    // 如未能获得当前用户，则返回 HTTP 401
//    String currentIdentity = authentication.getIdentity(httpRequest);
//    if (currentIdentity == null) {
//      httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//      return;
//    }

    // 如当前用户不允许访问指定服务，则返回 HTTP 403
    if (authorization.isAuthorized(httpRequest, BaseContext.getLoginUser())) {
      chain.doFilter(request, response);
      return;
    }
    httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
  }
}

