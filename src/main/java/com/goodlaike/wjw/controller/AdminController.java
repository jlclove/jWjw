package com.goodlaike.wjw.controller;

import javax.servlet.http.HttpServletRequest;

import com.goodlaike.wjw.service.loupan.LoupanService;
import com.goodlaike.wjw.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

  @Autowired
  private LoupanService loupanService;

  @RequestMapping("/home")
  protected String adminHome(HttpServletRequest request, Model model) {
    return "admin/home";
  }

  @RequestMapping("/login")
  protected String adminLogin(HttpServletRequest request, Model model) {
    return "admin/login";
  }

  @RequestMapping("/loupans")
  protected String adminLoupans(HttpServletRequest request, Model model) {
    model.addAttribute("menuId", "loupans");
    return "admin/loupan";
  }

  @RequestMapping("/loupans/{id}")
  protected String adminLoupanDetail(@PathVariable(value = "id") long id, HttpServletRequest request, Model model) {
    model.addAttribute("menuId", "loupans");
    model.addAttribute("detail", this.loupanService.findDetailById(id));
    return "admin/loupanDetail";
  }

  @RequestMapping("/loupans/add")
  protected String adminLoupanAdd(HttpServletRequest request, Model model) {
    model.addAttribute("menuId", "loupans");
    return "admin/loupanAdd";
  }

  @RequestMapping("/users")
  protected String adminUsers(HttpServletRequest request, Model model) {
    model.addAttribute("menuId", "users");
    return "admin/user";
  }

  @ModelAttribute("currentUser")
  protected UserView currentUser(HttpServletRequest request, Model model){
    return super.pollLogined(request);
  }
}
