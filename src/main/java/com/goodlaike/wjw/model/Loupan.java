package com.goodlaike.wjw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 楼盘
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public class Loupan implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  private long id;

  /**
   * 楼盘名
   */
  private String name;

  /**
   * 城市名
   */
  private String cityName;

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
   * 物业类型集合
   */
  private int statFunctions;

  /**
   * 建筑类型集合
   */
  private int structFunctions;

  /**
   * 装修情况
   */
  private int decoItems;

  /**
   * 产权年限集合
   */
  private int ageLimits;

  /**
   * 居室集合
   */
  private int layouts;

  /**
   * 开发商名
   */
  private String developerName;

  /**
   * 交通情况
   */
  private String traffic;

  /**
   * 配套设施
   */
  private String equipment;

  /**
   * 占地面积
   */
  private Double siteArea;

  /**
   * 建筑面积
   */
  private Double buildArea;

  /**
   * 容积率
   */
  private Double ratio;

  /**
   * 绿化率
   */
  private Double greenRate;

  /**
   * 车位比
   */
  private String carRate;

  /**
   * 楼栋数
   */
  private Integer buildingCnt;

  /**
   * 总户数
   */
  private Integer roomCnt;

  /**
   * 物业费
   */
  private Double propertyFee;

  /**
   * 物业公司名
   */
  private String propertyName;

  /**
   * 楼盘介绍
   */
  private String description;

  /**
   * 案场电话
   */
  private String linkerPhone;

  /**
   * 标签
   */
  private int flag;

  /**
   * 状态
   */
  private byte status;

  /**
   * 创建人
   */
  private int creator;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 更新人
   */
  private int updator;

  /**
   * 更新时间
   */
  private Date updateTime;

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

  public String getCityName() {
    return this.cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
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

  public int getStatFunctions() {
    return this.statFunctions;
  }

  public void setStatFunctions(int statFunctions) {
    this.statFunctions = statFunctions;
  }

  public int getStructFunctions() {
    return this.structFunctions;
  }

  public void setStructFunctions(int structFunctions) {
    this.structFunctions = structFunctions;
  }

  public int getDecoItems() {
    return this.decoItems;
  }

  public void setDecoItems(int decoItems) {
    this.decoItems = decoItems;
  }

  public int getAgeLimits() {
    return this.ageLimits;
  }

  public void setAgeLimits(int ageLimits) {
    this.ageLimits = ageLimits;
  }

  public int getLayouts() {
    return this.layouts;
  }

  public void setLayouts(int layouts) {
    this.layouts = layouts;
  }

  public String getDeveloperName() {
    return this.developerName;
  }

  public void setDeveloperName(String developerName) {
    this.developerName = developerName;
  }

  public String getTraffic() {
    return this.traffic;
  }

  public void setTraffic(String traffic) {
    this.traffic = traffic;
  }

  public String getEquipment() {
    return this.equipment;
  }

  public void setEquipment(String equipment) {
    this.equipment = equipment;
  }

  public Double getSiteArea() {
    return this.siteArea;
  }

  public void setSiteArea(Double siteArea) {
    this.siteArea = siteArea;
  }

  public Double getBuildArea() {
    return this.buildArea;
  }

  public void setBuildArea(Double buildArea) {
    this.buildArea = buildArea;
  }

  public Double getRatio() {
    return this.ratio;
  }

  public void setRatio(Double ratio) {
    this.ratio = ratio;
  }

  public Double getGreenRate() {
    return this.greenRate;
  }

  public void setGreenRate(Double greenRate) {
    this.greenRate = greenRate;
  }

  public String getCarRate() {
    return this.carRate;
  }

  public void setCarRate(String carRate) {
    this.carRate = carRate;
  }

  public Integer getBuildingCnt() {
    return this.buildingCnt;
  }

  public void setBuildingCnt(Integer buildingCnt) {
    this.buildingCnt = buildingCnt;
  }

  public Integer getRoomCnt() {
    return this.roomCnt;
  }

  public void setRoomCnt(Integer roomCnt) {
    this.roomCnt = roomCnt;
  }

  public Double getPropertyFee() {
    return this.propertyFee;
  }

  public void setPropertyFee(Double propertyFee) {
    this.propertyFee = propertyFee;
  }

  public String getPropertyName() {
    return this.propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLinkerPhone() {
    return this.linkerPhone;
  }

  public void setLinkerPhone(String linkerPhone) {
    this.linkerPhone = linkerPhone;
  }

  public byte getStatus() {
    return this.status;
  }

  public void setStatus(byte status) {
    this.status = status;
  }

  public int getFlag() {
    return this.flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  public int getCreator() {
    return this.creator;
  }

  public void setCreator(int creator) {
    this.creator = creator;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public int getUpdator() {
    return this.updator;
  }

  public void setUpdator(int updator) {
    this.updator = updator;
  }

  public Date getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "Loupan [id=" + id + ", name=" + name + ", cityName=" + cityName + ", districtName=" + districtName + ", avgPrice=" + avgPrice
        + ", address=" + address + ", statFunctions=" + statFunctions + ", structFunctions=" + structFunctions + ", decoItems=" + decoItems
        + ", ageLimits=" + ageLimits + ", layouts=" + layouts + ", developerName=" + developerName + ", traffic=" + traffic + ", equipment="
        + equipment + ", siteArea=" + siteArea + ", buildArea=" + buildArea + ", ratio=" + ratio + ", greenRate=" + greenRate + ", carRate="
        + carRate + ", buildingCnt=" + buildingCnt + ", roomCnt=" + roomCnt + ", propertyFee=" + propertyFee + ", propertyName="
        + propertyName + ", description=" + description + ", linkerPhone=" + linkerPhone + ", flag=" + flag + ", status=" + status
        + ", creator=" + creator + ", createTime=" + createTime + ", updator=" + updator + ", updateTime=" + updateTime + "]";
  }

}
