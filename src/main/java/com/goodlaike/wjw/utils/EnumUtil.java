package com.goodlaike.wjw.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 枚举工具类
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2016, Lianjia Group All Rights Reserved.
 */
public final class EnumUtil {
  /**
   * Enum.valueOf 的扩展方法
   * 
   * @param enumType 需要返回的枚举类
   * @param name 需要转换的枚举类 name
   * @param defaultValue 如果不满足转换时返回的默认值
   * @return T
   * @author Jail Hu
   * @version v1
   * @since 2016年12月28日 下午4:23:22
   */
  public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name, T defaultValue) {
    try {
      return Enum.valueOf(enumType, name);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  /**
   * Enum.valueOf 的扩展方法
   * <br>
   * 如果不存在name对应的枚举则返回 null<br>
   * 如果需要不存在报错的话，直接用 已知枚举类的 valueOf 方法吧
   * 
   * @param enumType 需要返回的枚举类
   * @param name 需要转换的枚举类 name
   * @return T
   * @author Jail Hu
   * @version v1
   * @since 2016年12月28日 下午4:28:28
   */
  public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
    return valueOf(enumType, name, null);
  }

  /**
   * Enum.valueOf 的扩展方法<br>
   * 返回转换后的枚举类数组<br>
   * <b>如果有无法转换的会直接报错</b>
   * 
   * @param enumType 需要返回的枚举类
   * @param names 需要转换的枚举类 name 数组
   * @param separator 数组元素的分隔符
   * @return {@code List<T>}
   * @author Jail Hu
   * @version v1
   * @since 2016年12月28日 下午4:23:22
   */
  public static <T extends Enum<T>> List<T> valuesOf(Class<T> enumType, String names, String separator) {
    Objects.requireNonNull(separator, "分隔符不允许为 null");
    if (names != null && !"".equals(names)) {
      List<T> list = new ArrayList<>();
      for (String name : names.split(separator)) {
        list.add(Enum.valueOf(enumType, name));
      }
      return list;
    } else {
      return Collections.emptyList();
    }
  }
}
