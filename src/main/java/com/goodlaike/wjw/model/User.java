package com.goodlaike.wjw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 用户ID
   */
  private int id;

  /**
   * 用户名
   */
  private String userName;

  /**
   * 密码盐
   */
  private String salt;

  /**
   * 用户密码
   */
  private String password;
  
  /**
   * 是否管理员
   */
  private boolean admin;

  /**
   * 状态
   */
  private byte status;

  /**
   * 创建人
   */
  private int creator;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 更新人
   */
  private int updator;

  /**
   * 更新时间
   */
  private Date updateTime;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getSalt() {
    return this.salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAdmin() {
    return this.admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public byte getStatus() {
    return this.status;
  }

  public void setStatus(byte status) {
    this.status = status;
  }

  public int getCreator() {
    return this.creator;
  }

  public void setCreator(int creator) {
    this.creator = creator;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public int getUpdator() {
    return this.updator;
  }

  public void setUpdator(int updator) {
    this.updator = updator;
  }

  public Date getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", userName=" + userName + ", salt=" + salt + ", password=" + password + ", admin=" + admin + ", status="
        + status + ", creator=" + creator + ", createTime=" + createTime + ", updator=" + updator + ", updateTime=" + updateTime + "]";
  }
}
