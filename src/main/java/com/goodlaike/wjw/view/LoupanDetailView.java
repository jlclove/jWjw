package com.goodlaike.wjw.view;

import java.util.List;
import java.util.Map;

import com.goodlaike.wjw.model.Loupan;
import com.goodlaike.wjw.model.LoupanPicture;

public class LoupanDetailView {

  /**
   * 楼盘对象
   */
  private Loupan loupan;

  /**
   * 楼盘图片集合
   */
  private Map<Byte, List<LoupanPicture>> picMap;

  public Loupan getLoupan() {
    return this.loupan;
  }

  public void setLoupan(Loupan loupan) {
    this.loupan = loupan;
  }

  public Map<Byte, List<LoupanPicture>> getPicMap() {
    return this.picMap;
  }

  public void setPicMap(Map<Byte, List<LoupanPicture>> picMap) {
    this.picMap = picMap;
  }

  @Override
  public String toString() {
    return "LoupanDetailView [loupan=" + loupan + ", picMap=" + picMap + "]";
  }
}
