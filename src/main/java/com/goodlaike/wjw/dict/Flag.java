package com.goodlaike.wjw.dict;

import java.util.Arrays;

import com.goodlaike.wjw.support.FlagSupport;

/**
 * 标签
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public enum Flag implements IFlag {

  //@formatter:off
  热推("热推", 20);
  //@formatter:on
  /**
   * 显示名称
   */
  private final String displayName;
  /**
   * 二进制中所在位置，从右往左从1开始累加1
   */
  private final int placeIndex;

  public int getPlaceIndex() {
    return this.placeIndex;
  }

  public String getDisplayName() {
    return this.displayName;
  }

  private Flag(String displayName, int placeIndex) {
    this.placeIndex = placeIndex;
    this.displayName = displayName;
  }
  
  public static void main(String[] args) {
    System.out.println(FlagSupport.enFlag(Arrays.asList(Flag.热推)));
  }
}
