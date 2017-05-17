package com.goodlaike.wjw.service.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.goodlaike.wjw.config.DaoManagement;
import com.goodlaike.wjw.model.User;

/**
 * User Dao
 * 
 * @author jail
 */
@Repository
@Lazy(value = true)
class UserDao extends DaoManagement {

  /**
   * 根据用户ID 获得用户
   * 
   * @param id 用户ID
   * @return {@link User}
   * @author jail
   */
  public User findUser(int id) {
    return super.sqlSessionCommon.selectOne("UserMapper.findById", id);
  }

  /**
   * 根据用户ID与密码 获得用户
   * 
   * @param id 用户ID
   * @param password 密码明码
   * @return {@link User}
   * @author jail
   */
  public User findUser(int id, String password) {
    Map<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("password", password);
    return super.sqlSessionCommon.selectOne("UserMapper.findById2", map);
  }



  /**
   * 根据用户名与密码获得用户
   * 
   * @param userName 用户名
   * @param password 密码明码
   * @return {@link User}
   * @author jail
   */
  public User findUser(String userName, String password) {
    Map<String, Object> map = new HashMap<>();
    map.put("userName", userName);
    map.put("password", password);
    return super.sqlSessionCommon.selectOne("UserMapper.findByUserName", map);
  }

  /**
   * 新增用户
   * 
   * @param userName 用户名
   * @param salt 密码盐
   * @param password 用户密码
   * @param operator 操作人
   * @return int
   * @author Jail Hu
   * @version v1
   * @since 2017年5月17日 下午11:00:10
   */
  public int addUser(String userName, String salt, String password, int operator) {
    Map<String, Object> map = new HashMap<>();
    map.put("userName", userName);
    map.put("password", password);
    map.put("salt", salt);
    map.put("creator", operator);
    map.put("updator", operator);
    super.sqlSessionCommon.insert("UserMapper.insert", map);
    return (Integer) map.get("id");
  }

  /**
   * 逻辑删除用户
   * 
   * @param id 用户ID
   * @param operator 操作人ID
   * @return int
   * @author jail
   */
  public int delete(int id, int operator) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("updator", operator);
    return super.sqlSessionCommon.update("UserMapper.delete", map);
  }

  /**
   * 修改密码
   * 
   * @param id 用户ID
   * @param password 密码明码
   * @param operator 操作人ID
   * @return Boolean
   * @author jail
   */
  public int changePassword(int id, String password, int operator) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("password", password);
    map.put("updator", operator);
    return super.sqlSessionCommon.update("UserMapper.changePassword", map);
  }


  /**
   * 获得指定用户名数量
   * 
   * @param userName 用户名
   * @param id 需要排除的用户id
   * @return boolean
   * @author Jail Hu
   */
  public int findUserNameCnt(String userName, Integer id) {
    HashMap<String, Object> map = new HashMap<>(2);
    map.put("userName", userName);
    map.put("id", id);
    return super.sqlSessionCommon.selectOne("UserMapper.findUserNameCnt", map);
  }
}
