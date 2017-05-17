package com.goodlaike.wjw.dict;

/**
 * 装修情况
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public enum DecoItem implements IFlag {

  //@formatter:off
  毛坯("毛坯", 1), 
  精装("精装", 2);
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

  private DecoItem(String displayName, int placeIndex) {
    this.placeIndex = placeIndex;
    this.displayName = displayName;
  }
}
