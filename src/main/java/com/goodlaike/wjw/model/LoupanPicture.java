package com.goodlaike.wjw.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 楼盘图片
 * 
 * @author Jail Hu (SE)
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 */
public class LoupanPicture implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * 主键ID
   */
  private long id;

  /**
   * 楼盘ID
   */
  private long loupanId;

  /**
   * 图片类型
   */
  private byte type;

  /**
   * 图片地址
   */
  private String picUrl;

  /**
   * 是否主图
   */
  private boolean main;

  /**
   * 创建人
   */
  private int creator;

  /**
   * 创建时间
   */
  private Date createTime;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getLoupanId() {
    return this.loupanId;
  }

  public void setLoupanId(long loupanId) {
    this.loupanId = loupanId;
  }

  public byte getType() {
    return this.type;
  }

  public void setType(byte type) {
    this.type = type;
  }

  public String getPicUrl() {
    return this.picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  public boolean isMain() {
    return this.main;
  }

  public void setMain(boolean main) {
    this.main = main;
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

  @Override
  public String toString() {
    return "LoupanPicture [id=" + id + ", loupanId=" + loupanId + ", type=" + type + ", picUrl=" + picUrl + ", main=" + main + ", creator="
        + creator + ", createTime=" + createTime + "]";
  }
}
