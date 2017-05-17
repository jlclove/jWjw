package com.goodlaike.wjw.dict;

/**
 * 标签声明接口 <br>
 * 用于转换 一堆的标签到一个 二进制数值<br>
 * <p>
 * 比如 1：地暖，2：中央空调 <br>
 * 当选中 1+2 则会转换成 11 即 3 用于存储<br>
 * 当选中 2， 则会转换成 10 即 2 用于存储<br>
 * 当选中 1， 则会转换为 01 即 1 用于存储<br>
 * </p>
 * <p>
 * <b>重要：</b>目前支持一个 Int 型的存储，即共 31位， placeIndex 从 1-31
 * </p>
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2016, Lianjia Group All Rights Reserved.
 */
public interface IFlag {
  /**
   * 占位偏移量
   */
  int offset = 1;
  /**
   * 标签所在位置,支持 1-31
   * 
   * @return int
   * @author Jail Hu
   * @version v1
   * @since 2016年12月22日 下午2:27:13
   */
  public int getPlaceIndex();
}