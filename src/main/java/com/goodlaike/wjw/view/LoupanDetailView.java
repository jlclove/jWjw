package com.goodlaike.wjw.view;

import java.util.List;
import java.util.Map;

import com.goodlaike.wjw.dict.AgeLimit;
import com.goodlaike.wjw.dict.DecoItem;
import com.goodlaike.wjw.dict.Flag;
import com.goodlaike.wjw.dict.LayoutType;
import com.goodlaike.wjw.dict.StatFunction;
import com.goodlaike.wjw.dict.StructFunction;
import com.goodlaike.wjw.model.Loupan;
import com.goodlaike.wjw.model.LoupanPicture;

public class LoupanDetailView {

  /**
   * 楼盘对象
   */
  private Loupan loupan;
  
  private List<AgeLimit> ageLimitList;
  private List<DecoItem> decoItemList;
  private List<Flag> flagList;
  private List<LayoutType> layoutTypeList;
  private List<StatFunction> statFunctionList;
  private List<StructFunction> structFunctionList;

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

  public List<AgeLimit> getAgeLimitList() {
    return this.ageLimitList;
  }

  public void setAgeLimitList(List<AgeLimit> ageLimitList) {
    this.ageLimitList = ageLimitList;
  }

  public List<DecoItem> getDecoItemList() {
    return this.decoItemList;
  }

  public void setDecoItemList(List<DecoItem> decoItemList) {
    this.decoItemList = decoItemList;
  }

  public List<Flag> getFlagList() {
    return this.flagList;
  }

  public void setFlagList(List<Flag> flagList) {
    this.flagList = flagList;
  }

  public List<LayoutType> getLayoutTypeList() {
    return this.layoutTypeList;
  }

  public void setLayoutTypeList(List<LayoutType> layoutTypeList) {
    this.layoutTypeList = layoutTypeList;
  }

  public List<StatFunction> getStatFunctionList() {
    return this.statFunctionList;
  }

  public void setStatFunctionList(List<StatFunction> statFunctionList) {
    this.statFunctionList = statFunctionList;
  }

  public List<StructFunction> getStructFunctionList() {
    return this.structFunctionList;
  }

  public void setStructFunctionList(List<StructFunction> structFunctionList) {
    this.structFunctionList = structFunctionList;
  }

  @Override
  public String toString() {
    return "LoupanDetailView [loupan=" + loupan + ", ageLimitList=" + ageLimitList + ", decoItemList=" + decoItemList + ", flagList="
        + flagList + ", layoutTypeList=" + layoutTypeList + ", statFunctionList=" + statFunctionList + ", structFunctionList="
        + structFunctionList + ", picMap=" + picMap + "]";
  }
}
