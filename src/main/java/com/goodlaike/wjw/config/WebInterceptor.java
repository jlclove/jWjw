package com.goodlaike.wjw.config;

import java.io.File;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.goodlaike.wjw.Application;
import com.goodlaike.wjw.view.UserView;

@Configuration
public class WebInterceptor extends WebMvcConfigurerAdapter {

  private Logger logger = LoggerFactory.getLogger(WebInterceptor.class);


  private String imgPath;
  private String saveDirctory;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.HOURS);
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").setCacheControl(cacheControl);
    registry.addResourceHandler("/imgs/**").addResourceLocations(this.getImgPath());
    super.addResourceHandlers(registry);
  }

  private String getImgPath() {
    imgPath = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    if (imgPath.contains(".jar")) {
      logger.info("===========>>> img url contains \".jar\" = [{}]", imgPath);
      imgPath = imgPath.substring(0, imgPath.indexOf(".jar"));
      logger.info("===========>>> img url removed \".jar\" = [{}]", imgPath);
      imgPath = imgPath.substring(0, imgPath.lastIndexOf("/") + 1);
      logger.info("===========>>> img url removed \"{}\" = [{}]", "/", imgPath);
    }
    imgPath += "imgs/";

    if (!imgPath.startsWith("file:")) {
      imgPath = "file:" + imgPath;
    }

    logger.info("===========>>> load imgs path = [{}]", imgPath);
    return imgPath;
  }

  public String getSaveDirectory() {
    if (saveDirctory == null) {
      saveDirctory = this.getImgPath();
      if (saveDirctory.startsWith("file:")) {
        saveDirctory = saveDirctory.replaceFirst("file:", "");
      }
    }
    return saveDirctory;
  }


  public static void main(String[] args) {
    String imgPath = "file://D:/workspace/fang-wap.jar";
    if (imgPath.contains(".jar")) {
      System.out.println("===========>>> img url contains \".jar\" = [" + imgPath + "]");
      imgPath = imgPath.substring(0, imgPath.indexOf(".jar"));
      System.out.println(imgPath);
      System.out.println("====" + File.separator);
      imgPath = imgPath.substring(0, imgPath.lastIndexOf("/") + 1);
      System.out.println(imgPath);
    }
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginedInterceptor()).addPathPatterns("/page/loupan/**", "/api/loupan/**").excludePathPatterns("/",
        "/api/loupan", "/static/**", "/imgs/**");

    registry.addInterceptor(adminLoginedInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login", "/static/**",
        "/imgs/**");
  }

  @Bean("loginedInterceptor")
  public LoginedInterceptor loginedInterceptor() {
    return new LoginedInterceptor();
  }

  @Bean("adminLoginedInterceptor")
  public AdminLoginedInterceptor adminLoginedInterceptor() {
    return new AdminLoginedInterceptor();
  }



  static class LoginedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Object object = request.getSession(true).getAttribute(IConstants.SESSION_USER);
      if (object != null) {
        return true;
      } else {
        // throw new UnloginedException();
        response.sendRedirect("/page/login");
        return false;
      }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

  }

  static class AdminLoginedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Object object = request.getSession(true).getAttribute(IConstants.SESSION_USER);
      if (object != null && ((UserView) object).isAdmin()) {
        return true;
      } else {
        // throw new UnloginedException();
        response.sendRedirect("/admin/login?msg=" + URLEncoder.encode("非法登录用户", "utf-8"));
        return false;
      }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

  }
}
