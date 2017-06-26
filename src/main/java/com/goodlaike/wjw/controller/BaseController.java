package com.goodlaike.wjw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.goodlaike.wjw.config.IConstants;
import com.goodlaike.wjw.exceptions.UnloginedException;
import com.goodlaike.wjw.view.UserView;

public abstract class BaseController {


  protected UserView pollLogined(HttpServletRequest request) {
    HttpSession session = request.getSession(true);
    return (UserView) session.getAttribute(IConstants.SESSION_USER);
  }

  protected void pushLogin(HttpServletRequest request, UserView user) {
    HttpSession session = request.getSession(true);
    session.setAttribute(IConstants.SESSION_USER, user);
  }
  
  protected void removeLogin(HttpServletRequest request) {
    HttpSession session = request.getSession(true);
    session.removeAttribute(IConstants.SESSION_USER);
  }

  @ExceptionHandler(value = UnloginedException.class)
  public ResponseEntity<?> unlogined() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
}
