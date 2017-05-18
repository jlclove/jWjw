package com.goodlaike.wjw.view;

public class LoupanDetailView {

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

  @Override
  public String toString() {
    return "LoupanListView [id=" + id + ", name=" + name + ", districtName=" + districtName + ", avgPrice=" + avgPrice + ", address="
        + address + ", layouts=" + layouts + "]";
  }
}
