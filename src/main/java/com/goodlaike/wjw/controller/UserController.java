package com.goodlaike.wjw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.wjw.model.Pagination;
import com.goodlaike.wjw.service.user.UserService;
import com.goodlaike.wjw.view.UserView;

@RestController
public class UserController extends BaseController {

  @Autowired
  private UserService userService;


  /**
   * 登录
   * <br>
   * 有 session，所以请把cookie 带上
   * 
   * @see UserService#login(String, String)
   */
  @RequestMapping(value = "/user/login", method = RequestMethod.POST)
  public UserView login(HttpServletRequest request, @RequestParam(value = "userName", required = true) String userName,
      @RequestParam(value = "password", required = true) String password) {
    UserView user = this.userService.login(userName, password);
    if (user == null) {
      throw new IllegalArgumentException("用户名或密码错误，请检查");
    } else {
      super.pushLogin(request, user);
      return user;
    }
  }

  /**
   * 获得当前登录用户
   */
  @RequestMapping(value = "/user/logined", method = RequestMethod.GET)
  public UserView logined(HttpServletRequest request) {
    return super.pollLogined(request);
  }

  /**
   * 退出登录
   */
  @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
  public boolean logout(HttpServletRequest request) {
    try {
      super.removeLogin(request);
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  /**
   * 添加用户
   */
  @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
  public boolean addUser(HttpServletRequest request, @RequestParam(value = "userName", required = true) String userName,
      @RequestParam(value = "password", required = true) String password) {
    UserView user = super.pollLogined(request);
    return this.userService.addUser(userName, password, user.getId()) > 0;
  }

  /**
   * 删除用户
   */
  @RequestMapping(value = "/admin/user/{id}", method = RequestMethod.DELETE)
  public boolean deleteUser(HttpServletRequest request, @PathVariable(value = "id") int id) {
    UserView user = super.pollLogined(request);
    return this.userService.deleteUser(id, user.getId());
  }

  /**
   * 获得用户信息
   */
  @RequestMapping(value = "/admin/user/{id}", method = RequestMethod.GET)
  public UserView getUser(HttpServletRequest request, @PathVariable(value = "id") int id) {
    return this.userService.findUserView(id);
  }

  /**
   * 用户名是否已存在
   * 
   * @see UserService#userNameExist(String, Integer)
   */
  @RequestMapping(value = "/admin/user/userNameExist", method = RequestMethod.POST)
  public boolean userNameExist(@RequestParam(value = "userName", required = true) String userName) {
    return this.userService.userNameExist(userName, null);
  }

  /**
   * 分页查询
   */
  @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
  public Pagination findList(@RequestParam(value = "pageNo", required = true, defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", required = true, defaultValue = "20") int pageSize,
      @RequestParam(value = "userName", required = false) String userName) {
    return this.userService.findPagination(pageNo, pageSize, userName);
  }
}
