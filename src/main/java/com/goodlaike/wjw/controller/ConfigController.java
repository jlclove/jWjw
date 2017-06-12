package com.goodlaike.wjw.controller;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.wjw.config.Resource;
import com.goodlaike.wjw.dict.Province;
import com.goodlaike.wjw.service.ConfigService;
import com.goodlaike.wjw.utils.RestUtil;

@RestController
public class ConfigController {

  @Autowired
  private ConfigService configService;

  @Autowired
  private Resource resource;

  /**
   * 获得完整配置
   * 
   * @see ConfigService#getFullConfig()
   */
  @RequestMapping("/config")
  protected Map<String, Object> config() {
    return this.configService.getFullConfig();
  }

  /**
   * 获得省份
   * 
   */
  @RequestMapping("/config/province")
  protected Map<Integer, Object> province() {
    return Stream.of(Province.values()).collect(Collectors.toMap(Province::getId, Province::getDisplayName));
  }

  /**
   * 获得区域
   * 
   */
  @RequestMapping("/config/district")
  protected String district(@RequestParam(value = "id", required = true) int id) {
    return RestUtil.exchange(this.resource.getDistrictUrl(), HttpMethod.GET, null, String.class, id);
  }

  @RequestMapping("/it/ping")
  protected long it() {
    return System.currentTimeMillis();
  }
}
