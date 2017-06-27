package com.goodlaike.wjw.service.loupan;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodlaike.wjw.model.LoupanPicture;

@Service
public class LoupanPictureService {


  @Autowired
  private LoupanPictureDao loupanPictureDao;

  /**
   * 根据楼盘ID 获得图片集合
   * 
   * @see LoupanPictureDao#findByLoupanId(long)
   */
  public List<LoupanPicture> findByLoupanId(long loupanId) {
    return this.loupanPictureDao.findByLoupanId(loupanId);
  }

  /**
   * 新增楼盘图片
   *
   * @see LoupanPictureDao#insert(List, int)
   */
  public boolean insert(List<Map<String, Object>> picList, int operator) {
    if (picList == null || picList.size() == 0) {
      return true;
    }
    return this.loupanPictureDao.insert(picList, operator) == picList.size();
  }

  /**
   * 新增楼盘图片
   *
   * @see LoupanPictureDao#insert(List, int)
   */
  public int insert(Map<String, Object> picObj, int operator) {
    if (picObj == null) {
      return 0;
    }
    return this.loupanPictureDao.insert(picObj, operator);
  }

  /**
   * 删除照片
   * 
   */
  public boolean delete(List<Long> ids) {
    if (ids == null || ids.size() == 0) {
      return true;
    }
    return this.loupanPictureDao.delete(ids) == ids.size();
  }


  /**
   * 设置主图
   * 
   * @see LoupanPictureDao#setMain(long)
   */
  public void setMain(long id) {
    this.loupanPictureDao.setMain(id);
  }
}
