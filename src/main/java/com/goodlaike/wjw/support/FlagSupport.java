package com.goodlaike.wjw.support;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.goodlaike.wjw.dict.IFlag;

/**
 * 标签支持<br>
 * <p>
 * 针对 {@link IFlag} 的支持方法<br>
 * 1、多个 Flag 转 int
 * 2、int 转 多个 Flag
 * </p>
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2016, Lianjia Group All Rights Reserved.
 */
public final class FlagSupport {
  /**
   * 进行 int 转换成 标签列表
   * 
   * @param value 需要转换的数值
   * @param clazz 最终需要的 Flag 类
   * @return List<T extends IFlag,Enum>
   * @author Jail Hu
   * @version v1
   * @since 2016年12月22日 下午2:51:06
   */
  @SuppressWarnings("hiding")
  public static <T extends IFlag, Enum> List<T> deFlag(int value, Class<T> clazz) {
    return deFlag(value, () -> Arrays.asList(clazz.getEnumConstants()));
  }

  /**
   * 进行 int 转换成 标签列表
   * 
   * @param value 需要转换的数值
   * @param supplier 标签数据提供者
   * @return List<T extends IFlag>
   * @author Jail Hu
   * @version v1
   * @since 2016年12月22日 下午2:49:19
   */
  public static <T extends IFlag> List<T> deFlag(int value, Supplier<List<T>> supplier) {
    return supplier.get().stream().filter((element) -> ((value & (1 << (element.getPlaceIndex() - IFlag.offset))) != 0))
        .collect(Collectors.toList());
  }

  /**
   * 进行 Flag 转换成 int
   * 
   * @param flagList 需要转换的标签列表
   * @return int
   * @author Jail Hu
   * @version v1
   * @since 2016年12月22日 下午2:47:01
   */
  public static <T extends IFlag> int enFlag(List<T> flagList) {
    if (CollectionUtils.isEmpty(flagList)) {
      return 0;
    }
    return flagList.stream()
        .collect(Collectors.reducing(0, IFlag::getPlaceIndex, (partialResult, index) -> partialResult | (1 << (index - IFlag.offset))));
  }
}
