package com.goodlaike.wjw.utils;

import java.util.UUID;

public class RandomUtil {
  /**
   * 获得32位随机 uuid
   * 
   * @return String
   * @author jail
   */
  public final static String getUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
}
