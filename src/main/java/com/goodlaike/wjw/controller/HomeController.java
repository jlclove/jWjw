package com.goodlaike.wjw.controller;

import com.goodlaike.wjw.service.loupan.LoupanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class HomeController  {

  @Autowired
  private LoupanService loupanService;

  @RequestMapping("/login")
  protected String login(Model model) {
    return "login";
  }

  @RequestMapping("/loupan")
  protected String list(Model model) {
    return "list";
  }

  @RequestMapping("/loupan/{id}")
  protected String detail(@PathVariable(value = "id") long id, Model model) {
    model.addAttribute("loupan", this.loupanService.findDetailById(id));
    return "detail";
  }

  @RequestMapping("/5000")
  protected String home2() {
    return "hello";
  }
}
