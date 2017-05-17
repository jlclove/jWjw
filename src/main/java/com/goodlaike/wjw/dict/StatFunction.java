package com.goodlaike.wjw.dict;

/**
 * 物业类型
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public enum StatFunction implements IFlag {

  //@formatter:off
  普通住宅("普通住宅", 1), 
  商铺("商铺", 2);
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

  private StatFunction(String displayName, int placeIndex) {
    this.placeIndex = placeIndex;
    this.displayName = displayName;
  }
}
