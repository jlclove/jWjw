package com.goodlaike.wjw.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.goodlaike.wjw.model.Pagination;
import com.goodlaike.wjw.model.User;
import com.goodlaike.wjw.utils.RandomUtil;
import com.goodlaike.wjw.view.UserView;

/**
 * 
 * @author jail
 */
@Service
@Lazy(true)
public class UserService {

  @Autowired
  private UserDao userDao;


  /**
   * 获得指定用户名数量
   * 
   * @see UserDao#findUserNameCnt(String, Integer)
   */
  private int findUserNameCnt(String userName, Integer id) {
    return this.userDao.findUserNameCnt(userName, id);
  }

  /**
   * 用户名是否已存在
   * <br>
   * 如果结果大于0则表示已存在
   * 
   * @see #findUserNameCnt(String, Integer)
   */
  public boolean userNameExist(String userName, Integer id) {
    return this.findUserNameCnt(userName, id) > 0;
  }

  /**
   * 根据用户名与密码获得用户
   *
   * @see UserDao#findByUserName(String, String)
   */
  public User findUser(String userName, String password) {
    return this.userDao.findByUserName(userName, password);
  }

  /**
   * 根据用户ID与密码 获得用户
   *
   * @see UserDao#findById2(id, String)
   */
  private User findUser(int id, String password) {
    return this.userDao.findById2(id, password);
  }

  /**
   * 获得用于显示用的用户视图
   */
  public UserView findUserView(int id) {
    return this.convertView(this.findUser(id));
  }

  /**
   * 登录并返回用户
   *
   * @see #findUser(String, String)
   */
  public UserView login(String userName, String password) {
    return this.convertView(this.findUser(userName, password));
  }


  private UserView convertView(User user) {
    if (user == null) {
      return null;
    } else {
      UserView view = new UserView();
      BeanUtils.copyProperties(user, view);
      return view;
    }
  }


  /**
   * 根据用户ID 获得用户
   * 
   * @see UserDao#findById(int)
   */
  private User findUser(int id) {
    return this.userDao.findById(id);
  }


  /**
   * 新增用户
   * 
   * @see UserDao#addUser(String, String, String, int)
   */
  public int addUser(String userName, String password, int operator) {
    Assert.hasText(userName, "用户名不能为空");
    Assert.isTrue(password != null && password.length() > 5 && password.length() < 17, "密码不能为空且为6-16个字符");
    Assert.isTrue(!this.userNameExist(userName, null), "用户名已存在");
    return this.userDao.insert(userName, RandomUtil.getUUID(), password, operator);
  }


  /**
   * 修改密码
   * 
   * @see UserDao#changePassword(int, String, int)
   * 
   */
  public boolean changePassword(int id, String oldPassword, String newPassword, int operator) {
    Assert.isTrue(newPassword != null && newPassword.length() > 5 && newPassword.length() < 17, "密码不能为空且为6-16个字符");
    if (oldPassword != null) {
      Assert.state(this.findUser(id, oldPassword) != null, "原始密码不符");
    }
    return this.userDao.changePassword(id, newPassword, operator) == 1;
  }

  /**
   * 逻辑删除用户
   * 
   * @see UserDao#delete(int, int)
   */
  public boolean deleteUser(int id, int operator) {
    return this.userDao.delete(id, operator) == 1;
  }



  /**
   * 查询列表
   * 
   * @see UserDao#findList(int, int, String)
   */
  private List<User> findList(int pageNo, int pageSize, String userName) {
    if (pageNo <= 0) {
      pageNo = 1;
    }
    return this.userDao.findList(pageNo, pageSize, userName);
  }

  /**
   * 查询列表数据总数
   * 
   * @see UserDao#findListCount(String)
   */
  private int findListCount(String userName) {
    return this.userDao.findListCount(userName);
  }


  /**
   * 分页查询
   * 
   */
  public Pagination findPagination(int pageNo, int pageSize, String userName) {
    if (pageNo <= 0) {
      pageNo = 1;
    }
    if (pageSize <= 0) {
      pageSize = 20;
    }
    Pagination page = new Pagination();

    List<User> userList = this.findList(pageNo, pageSize, userName);

    List<UserView> userViewList = new ArrayList<>(userList.size());
    userList.forEach((u) -> {
      UserView view = new UserView();
      BeanUtils.copyProperties(u, view);
      userViewList.add(view);
    });
    page.setList(userViewList);
    page.setTotalRecords(this.findListCount(userName));
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    return page;
  }
}
