package com.goodlaike.wjw.dict;

/**
 * 户型类型
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public enum LayoutType implements IFlag {

  //@formatter:off
  一居("1居", 1), 
  二居("2居", 2),
  三居("3居", 3),
  四居("4居", 4),
  五居("5居", 5),
  六居("6居", 6);
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

  private LayoutType(String displayName, int placeIndex) {
    this.placeIndex = placeIndex;
    this.displayName = displayName;
  }
}
