package com.goodlaike.wjw.service.loupan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.goodlaike.wjw.config.DaoManagement;
import com.goodlaike.wjw.model.LoupanPicture;

/**
 * LoupanPicture Dao
 * 
 * @author jail
 */
@Repository
@Lazy(value = true)
class LoupanPictureDao extends DaoManagement {

  /**
   * 根据楼盘ID 获得图片集合
   * 
   * @param loupanId 楼盘ID
   * @return {@link List<LoupanPicture>}
   * @author jail
   */
  public List<LoupanPicture> findByLoupanId(long loupanId) {
    return super.sqlSessionCommon.selectList("LoupanPictureMapper.findByLoupanId", loupanId);
  }

  /**
   * 新增楼盘图片
   * 
   * @param picList 图片数据集合,需要用到属性如下：
   *        <ul>
   *        <li>loupanId：楼盘Id</li>
   *        <li>type：图片类型</li>
   *        <li>picUrl：图片地址</li>
   *        </ul>
   * @param operator 操作人ID
   * @return int
   * @author Jail Hu
   * @version v1
   * @since 2017年5月18日 下午10:13:49
   */
  public int insert(List<Map<String, Object>> picList, int operator) {
    Map<String, Object> params = new HashMap<>();
    params.put("picList", picList);
    params.put("operator", operator);
    return super.sqlSessionCommon.insert("LoupanPictureMapper.insert", params);
  }

  public int insert(Map<String, Object> picObj, int operator) {
    Map<String, Object> params = new HashMap<>();
    params.put("pic", picObj);
    params.put("operator", operator);
    return super.sqlSessionCommon.insert("LoupanPictureMapper.insertOne", params);
  }

  /**
   * 删除照片
   * 
   * @param ids 照片ID集合
   * @return int
   * @author jail
   */
  public int delete(List<Long> ids) {
    return super.sqlSessionCommon.update("LoupanPictureMapper.delete", ids);
  }

  /**
   * 设置主图
   * 
   * @param id 图片ID
   * @author Jail Hu
   * @version v1
   * @since 2017年5月24日 下午10:45:47
   */
  public void setMain(long id) {
    super.sqlSessionCommon.update("LoupanPictureMapper.setMain", id);
    super.sqlSessionCommon.update("LoupanPictureMapper.setMain2", id);
  }
}
