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

  @Override
  public String toString() {
    return "UserView [id=" + id + ", userName=" + userName + "]";
  }
}
