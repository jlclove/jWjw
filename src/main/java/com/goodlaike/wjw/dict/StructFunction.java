package com.goodlaike.wjw.dict;

/**
 * 建筑类型
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public enum StructFunction implements IFlag {

  //@formatter:off
  板楼("板楼", 1), 
  高层("高层", 2);
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

  private StructFunction(String displayName, int placeIndex) {
    this.placeIndex = placeIndex;
    this.displayName = displayName;
  }
}
