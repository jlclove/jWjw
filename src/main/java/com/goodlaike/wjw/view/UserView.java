package com.goodlaike.wjw.view;

import java.util.Date;

public class UserView {

  /**
   * 用户ID
   */
  private int id;

  /**
   * 用户名
   */
  private String userName;

  private boolean admin;

  private int updator;

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

  public boolean isAdmin() {
    return this.admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
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
    return "UserView [id=" + id + ", userName=" + userName + ", admin=" + admin + ", updator=" + updator + ", updateTime=" + updateTime
        + "]";
  }

}
