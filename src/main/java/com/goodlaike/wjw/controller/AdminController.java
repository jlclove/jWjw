package com.goodlaike.wjw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @RequestMapping("/home")
  protected String adminHome(HttpServletRequest request, Model model) {
    return "admin/home";
  }

  @RequestMapping("/login")
  protected String adminLogin(HttpServletRequest request, Model model) {
    return "admin/login";
  }
}
