package com.goodlaike.wjw.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.wjw.service.user.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;
}
