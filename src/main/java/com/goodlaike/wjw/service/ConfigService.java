package com.goodlaike.wjw.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.goodlaike.wjw.dict.AgeLimit;
import com.goodlaike.wjw.dict.DecoItem;
import com.goodlaike.wjw.dict.Flag;
import com.goodlaike.wjw.dict.LayoutType;
import com.goodlaike.wjw.dict.Order;
import com.goodlaike.wjw.dict.PictureType;
import com.goodlaike.wjw.dict.StatFunction;
import com.goodlaike.wjw.dict.StructFunction;
import com.google.common.collect.ImmutableMap;

@Service
public class ConfigService {

  /**
   * 获得完整配置
   * 
   * @return {@code Map<String, Object>}
   * @author Jail Hu
   * @version v1
   * @since 2017年5月18日 下午10:04:33
   */
  public Map<String, Object> getFullConfig() {
    Map<String, Object> config = new HashMap<>();
    config.put("ageLimit", Stream.of(AgeLimit.values()).map((v) -> ImmutableMap.of("name", v.getDisplayName(), "value", v.name()))
        .collect(Collectors.toList()));
    config.put("decoItem", Stream.of(DecoItem.values()).map((v) -> ImmutableMap.of("name", v.getDisplayName(), "value", v.name()))
        .collect(Collectors.toList()));
    config.put("layoutType", Stream.of(LayoutType.values()).map((v) -> ImmutableMap.of("name", v.getDisplayName(), "value", v.name()))
        .collect(Collectors.toList()));
    config.put("structFunction", Stream.of(StructFunction.values())
        .map((v) -> ImmutableMap.of("name", v.getDisplayName(), "value", v.name())).collect(Collectors.toList()));
    config.put("statFunction", Stream.of(StatFunction.values()).map((v) -> ImmutableMap.of("name", v.getDisplayName(), "value", v.name()))
        .collect(Collectors.toList()));
    config.put("pictureType",
        Stream.of(PictureType.values()).map((v) -> ImmutableMap.of("name", v.name(), "value", v.name())).collect(Collectors.toList()));
    config.put("orderType",
        Stream.of(Order.values()).map((v) -> ImmutableMap.of("name", v.name(), "value", v.name())).collect(Collectors.toList()));
    config.put("flag",
        Stream.of(Flag.values()).map((v) -> ImmutableMap.of("name", v.name(), "value", v.name())).collect(Collectors.toList()));
    return config;
  }
}
