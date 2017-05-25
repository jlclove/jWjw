package com.goodlaike.wjw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.wjw.service.ConfigService;

@RestController
public class ConfigController {

  @Autowired
  private ConfigService configService;

  /**
   * 获得完整配置
   * 
   * @see ConfigService#getFullConfig()
   */
  @RequestMapping("/config")
  protected Map<String, Object> config() {
    return this.configService.getFullConfig();
  }
}
