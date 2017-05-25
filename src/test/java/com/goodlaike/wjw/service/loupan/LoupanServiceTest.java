package com.goodlaike.wjw.service.loupan;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.wjw.BaseTest;
import com.goodlaike.wjw.dict.DecoItem;
import com.goodlaike.wjw.dict.Flag;
import com.goodlaike.wjw.dict.LayoutType;

public class LoupanServiceTest extends BaseTest {

  @Autowired
  private LoupanService loupanService;


  private long insert() {
    return this.loupanService.insert("测试楼盘", "上海", "什么区域", null, "这是地址", null, null,
        Arrays.asList(DecoItem.毛坯, DecoItem.精装).stream().map((s) -> s.name()).collect(Collectors.joining(",")), null,
        Arrays.asList(LayoutType.一居, LayoutType.三居, LayoutType.五居).stream().map((s) -> s.name()).collect(Collectors.joining(",")), null,
        "交通", "设施", 123.5, 1.7, 16.7, null, "乱来", null, null, null, "物业公司", "描述", "13866554411",
        Arrays.asList(Flag.热推).stream().map((s) -> s.name()).collect(Collectors.joining(",")), 1);
  }

  @Test
  public void testFindById() {
    long id = insert();
    assertNotNull(this.loupanService.findById(id));
  }

  @Test
  public void testInsert() {
    assertTrue(insert() > 0);
  }

  @Test
  public void testUpdate() {
    long id = insert();

    assertTrue(this.loupanService.update(id, "什么区域2", null, "这是地址2", null, null,
        Arrays.asList(DecoItem.毛坯, DecoItem.精装).stream().map((s) -> s.name()).collect(Collectors.joining(",")), null,
        Arrays.asList(LayoutType.一居, LayoutType.三居, LayoutType.五居).stream().map((s) -> s.name()).collect(Collectors.joining(",")), null,
        "交通2", "设施2", 123.5, 1.7, 16.7, null, "乱来2", null, null, null, "物业公司2", "描述2", "13866554411",
        Arrays.asList(Flag.热推).stream().map((s) -> s.name()).collect(Collectors.joining(",")), 1));
  }

  @Test
  public void testDelete() {
    long id = insert();
    assertTrue(this.loupanService.delete(id, 1));
  }

  @Test
  public void testFindList() {
    System.out.println(this.loupanService.findList(1, null, null, null, null, null));
    System.out.println(this.loupanService.findList(1, "测试", null, null, null, null));
    System.out.println(this.loupanService.findList(1, null, "上海", null, null, null));
    System.out.println(this.loupanService.findList(1, null, null, "什么区域", null, null));
    System.out.println(this.loupanService.findList(1, null, null, null,
        Arrays.asList(LayoutType.一居, LayoutType.三居).stream().map((s) -> s.name()).collect(Collectors.joining(",")), null));
    System.out.println(this.loupanService.findList(1, null, null, null, null, "最近更新"));
  }

}
