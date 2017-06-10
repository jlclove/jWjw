package com.goodlaike.wjw.model;

import java.util.List;

/**
 * 分页类
 *
 * @author Jail Hu
 * @date 2014年11月12日
 */
public class Pagination {
  /**
   * 查询结果集
   */
  private List<?> list;
  /**
   * 页号 第一页为1
   */
  private int pageNo = 1;
  /**
   * 页尺寸
   */
  private int pageSize = 1;

  /**
   * 总结果数
   */
  private long totalRecords;

  /**
   * 获得 list List<E>
   *
   * @return list
   */
  public List<?> getList() {
    return list;
  }

  /**
   * 设置 list
   *
   * @param list
   */
  public void setList(List<?> list) {
    this.list = list;
  }

  /**
   * 获得 pageNo int
   *
   * @return pageNo
   */
  public int getPageNo() {
    return pageNo;
  }

  /**
   * 设置 pageNo
   *
   * @param pageNo
   */
  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  /**
   * 获得 pageSize int
   *
   * @return pageSize
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * 设置 pageSize
   *
   * @param pageSize
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * 获得总记录数
   *
   * @return int
   */
  public long getTotalRecords() {
    return this.totalRecords;
  }

  /**
   * 设置总记录数
   *
   * @param totalRecords
   */
  public void setTotalRecords(long totalRecords) {
    this.totalRecords = totalRecords;
  }

  /**
   * 获得 总页面数
   *
   * @return int
   */
  public long getTotalPages() {
    return this.totalRecords % this.pageSize == 0 ? this.totalRecords / this.pageSize : (this.totalRecords / this.pageSize) + 1;
  }

  @Override
  public String toString() {
    return "Pagination [list=" + list + ", pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalRecords=" + totalRecords + ", totalPages="
        + getTotalPages() + "]";
  }
}
