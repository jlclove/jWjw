package com.goodlaike.wjw.service.user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.wjw.BaseTest;

public class UserServiceTest extends BaseTest {

  @Autowired
  private UserService userService;

  @Test
  public void testUserNameExist() {
    int id = this.userService.addUser("hello", "abcefg", 1);
    assertTrue(this.userService.userNameExist("hello", null));
    assertFalse(this.userService.userNameExist("hello", id));
  }

  @Test
  public void testFindUserStringString() {
    assertTrue(this.userService.addUser("hello", "abcefg", 1) > 0);
    assertNotNull(this.userService.findUser("hello", "abcefg"));
  }

  @Test
  public void testFindUserView() {
    int id = this.userService.addUser("hello", "abcefg", 1);
    assertNotNull(this.userService.findUserView(id));
  }

  @Test
  public void testAddUser() {
    assertTrue(this.userService.addUser("hello", "abcefghij", 1) > 0);
  }

  @Test
  public void testChangePassword() {
    int id = this.userService.addUser("hello", "abcefg", 1);
    assertTrue(this.userService.changePassword(id, "abcefg", "cbaaac", 1));
    assertTrue(this.userService.changePassword(id, null, "dddccc", 1));
  }

  @Test
  public void testDeleteUser() {
    int id = this.userService.addUser("hello", "abcefg", 1);
    assertTrue(this.userService.deleteUser(id, 1));
  }

}
