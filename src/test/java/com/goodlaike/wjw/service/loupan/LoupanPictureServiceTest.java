package com.goodlaike.wjw.service.loupan;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodlaike.wjw.BaseTest;
import com.google.common.collect.ImmutableMap;

public class LoupanPictureServiceTest extends BaseTest {

  @Autowired
  private LoupanPictureService loupanPictureService;

  @Test
  public void testFindByLoupanId() {
    fail("Not yet implemented");
  }

  @Test
  public void testInsertListOfMapOfStringObjectInt() {
    fail("Not yet implemented");
  }

  @Test
  public void testInsertMapOfStringObjectInt() {
    System.out.println(
        this.loupanPictureService.insert(ImmutableMap.of("loupanId", 7L, "type", 1, "picUrl", "demo_600x400.jpg", "main", true), 1));
  }

  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }

  @Test
  public void testSetMain() {
    fail("Not yet implemented");
  }

}
