package com.goodlaike.wjw.config;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.goodlaike.wjw.exceptions.UnloginedException;

@Configuration
public class WebInterceptor extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.HOURS);
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").setCacheControl(cacheControl);
    super.addResourceHandlers(registry);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginedInterceptor()).addPathPatterns("/", "/admin/**", "/loupan/**").excludePathPatterns("/loupan", "/loupan/",
        "/static/**");
  }

  @Bean
  public LoginedInterceptor loginedInterceptor() {
    return new LoginedInterceptor();
  }

  static class LoginedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Object object = request.getSession(true).getAttribute(IConstants.SESSION_USER);
      if (object != null) {
        return true;
      } else {
        throw new UnloginedException();
      }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

  }
}
