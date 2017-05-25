package com.goodlaike.wjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController  {

  @RequestMapping("/")
  protected String home() {
    return "hello";
  }

  @RequestMapping("/5000")
  protected String home2() {
    return "hello";
  }
}
