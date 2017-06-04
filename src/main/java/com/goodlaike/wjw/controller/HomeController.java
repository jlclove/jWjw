package com.goodlaike.wjw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping("/page/login")
  protected String login(HttpServletRequest request, Model model) {
    model.addAttribute("referer", request.getHeader("referer"));
    return "login";
  }

  @RequestMapping({"/"})
  protected String list(Model model) {
    return "list";
  }

  @RequestMapping("/page/loupan/{id}")
  protected String detail(@PathVariable(value = "id") long id, Model model) {
    return "detail";
  }

}
