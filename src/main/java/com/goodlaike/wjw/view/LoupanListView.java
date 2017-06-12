package com.goodlaike.wjw.view;

import java.util.List;

import com.goodlaike.wjw.dict.LayoutType;

public class LoupanListView {

  /**
   * 主键
   */
  private long id;

  /**
   * 楼盘名
   */
  private String name;

  /**
   * 区域名
   */
  private String districtName;

  /**
   * 均价
   */
  private Double avgPrice;

  /**
   * 楼盘地址
   */
  private String address;

  /**
   * 居室集合
   */
  private int layouts;
  
  private List<LayoutType> layoutTypeList;
  
  /**
   * 列表主图
   */
  private String mainPic;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDistrictName() {
    return this.districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }

  public Double getAvgPrice() {
    return this.avgPrice;
  }

  public void setAvgPrice(Double avgPrice) {
    this.avgPrice = avgPrice;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getLayouts() {
    return this.layouts;
  }

  public void setLayouts(int layouts) {
    this.layouts = layouts;
  }

  public String getMainPic() {
    return this.mainPic;
  }

  public void setMainPic(String mainPic) {
    this.mainPic = mainPic;
  }

  public List<LayoutType> getLayoutTypeList() {
    return this.layoutTypeList;
  }

  public void setLayoutTypeList(List<LayoutType> layoutTypeList) {
    this.layoutTypeList = layoutTypeList;
  }

  @Override
  public String toString() {
    return "LoupanListView [id=" + id + ", name=" + name + ", districtName=" + districtName + ", avgPrice=" + avgPrice + ", address="
        + address + ", layouts=" + layouts + ", layoutTypeList=" + layoutTypeList + ", mainPic=" + mainPic + "]";
  }
}
