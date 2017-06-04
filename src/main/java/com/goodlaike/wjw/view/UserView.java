package com.goodlaike.wjw.view;

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

  @Override
  public String toString() {
    return "UserView [id=" + id + ", userName=" + userName + ", admin=" + admin + "]";
  }
}
