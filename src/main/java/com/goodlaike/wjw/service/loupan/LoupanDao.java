package com.goodlaike.wjw.service.loupan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.goodlaike.wjw.config.DaoManagement;
import com.goodlaike.wjw.model.Loupan;
import com.goodlaike.wjw.view.LoupanListView;

/**
 * Loupan Dao
 * 
 * @author jail
 */
@Repository
@Lazy(value = true)
class LoupanDao extends DaoManagement {

  /**
   * 根据ID 获得楼盘
   * 
   * @param id 楼盘ID
   * @return {@link Loupan}
   * @author jail
   */
  public Loupan findById(long id) {
    return super.sqlSessionCommon.selectOne("LoupanMapper.findById", id);
  }

  /**
   * 新增楼盘并返回楼盘ID
   * 
   * @param name 楼盘名
   * @param cityName 城市名
   * @param districtName 区域名
   * @param avgPrice 均价
   * @param address 地址
   * @param statFunctions 物业类型聚合值
   * @param structFunctions 建筑类型聚合值
   * @param decoItems 装修情况聚合值
   * @param ageLimits 产权年限聚合值
   * @param layouts 居室聚合值
   * @param developerName 开发商
   * @param traffic 交通情况
   * @param equipment 配套设施
   * @param siteArea 占地面积
   * @param buildArea 建筑面积
   * @param ratio 容积率
   * @param greenRate 绿化率
   * @param carRate 车位比
   * @param buildingCnt 栋座数
   * @param roomCnt 户数
   * @param propertyFee 物业费
   * @param propertyName 物业公司
   * @param description 描述
   * @param linkerPhone 案场电话
   * @param operator 操作人ID
   * @return long
   * @author Jail Hu
   * @version v1
   * @since 2017年5月18日 下午10:13:49
   */
  public long insert(String name, String cityName, String districtName, Double avgPrice, String address, int statFunctions,
      int structFunctions, int decoItems, int ageLimits, int layouts, String developerName, String traffic, String equipment,
      Double siteArea, Double buildArea, Double ratio, Double greenRate, String carRate, Integer buildingCnt, Integer roomCnt,
      Double propertyFee, String propertyName, String description, String linkerPhone, int operator) {
    Map<String, Object> params = new HashMap<>(32);
    params.put("name", name);
    params.put("cityName", cityName);
    params.put("districtName", districtName);
    params.put("avgPrice", avgPrice);
    params.put("address", address);
    params.put("statFunctions", statFunctions);
    params.put("structFunctions", structFunctions);
    params.put("decoItems", decoItems);
    params.put("ageLimits", ageLimits);
    params.put("layouts", layouts);
    params.put("developerName", developerName);
    params.put("traffic", traffic);
    params.put("equipment", equipment);
    params.put("siteArea", siteArea);
    params.put("buildArea", buildArea);
    params.put("ratio", ratio);
    params.put("greenRate", greenRate);
    params.put("carRate", carRate);
    params.put("buildingCnt", buildingCnt);
    params.put("roomCnt", roomCnt);
    params.put("propertyFee", propertyFee);
    params.put("propertyName", propertyName);
    params.put("description", description);
    params.put("linkerPhone", linkerPhone);
    params.put("operator", operator);
    super.sqlSessionCommon.insert("LoupanMapper.insert", params);
    return (Long) params.get("id");
  }

  /**
   * 逻辑删除楼盘
   * 
   * @param id 楼盘ID
   * @param operator 操作人ID
   * @return int
   * @author jail
   */
  public int delete(long id, int operator) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("updator", operator);
    return super.sqlSessionCommon.update("LoupanMapper.delete", map);
  }

  /**
   * 查询列表
   * 
   * @param pageNo 页数，从1开始
   * @param name 楼盘名，左 like
   * @param cityName 城市名
   * @param districtName 区域名
   * @param layouts 居室聚合值
   * @param order 排序字段
   * @return {@code List<LoupanListView>}
   * @author Jail Hu
   * @version v1
   * @since 2017年5月18日 下午10:53:36
   */
  public List<LoupanListView> findList(int pageNo, String name, String cityName, String districtName, Integer layouts, String order) {
    Map<String, Object> params = new HashMap<>();
    params.put("indexStart", (pageNo - 1) * 20);
    params.put("pageSize", 20);
    params.put("name", name);
    params.put("cityName", cityName);
    params.put("districtName", districtName);
    params.put("layouts", layouts);
    params.put("order", order);
    return super.sqlSessionCommon.selectList("LoupanMapper.findList", params);
  }


  /**
   * 更新楼盘
   * 
   * @param id 楼盘ID
   * @param districtName 区域名
   * @param avgPrice 均价
   * @param address 地址
   * @param statFunctions 物业类型聚合值
   * @param structFunctions 建筑类型聚合值
   * @param decoItems 装修情况聚合值
   * @param ageLimits 产权年限聚合值
   * @param layouts 居室聚合值
   * @param developerName 开发商
   * @param traffic 交通情况
   * @param equipment 配套设施
   * @param siteArea 占地面积
   * @param buildArea 建筑面积
   * @param ratio 容积率
   * @param greenRate 绿化率
   * @param carRate 车位比
   * @param buildingCnt 栋座数
   * @param roomCnt 户数
   * @param propertyFee 物业费
   * @param propertyName 物业公司
   * @param description 描述
   * @param linkerPhone 案场电话
   * @param operator 操作人ID
   * @return long
   * @author Jail Hu
   * @version v1
   * @since 2017年5月18日 下午10:13:49
   */
  public long update(long id, String districtName, Double avgPrice, String address, int statFunctions, int structFunctions, int decoItems,
      int ageLimits, int layouts, String developerName, String traffic, String equipment, Double siteArea, Double buildArea, Double ratio,
      Double greenRate, String carRate, Integer buildingCnt, Integer roomCnt, Double propertyFee, String propertyName, String description,
      String linkerPhone, int operator) {
    Map<String, Object> params = new HashMap<>(32);
    params.put("id", id);
    params.put("districtName", districtName);
    params.put("avgPrice", avgPrice);
    params.put("address", address);
    params.put("statFunctions", statFunctions);
    params.put("structFunctions", structFunctions);
    params.put("decoItems", decoItems);
    params.put("ageLimits", ageLimits);
    params.put("layouts", layouts);
    params.put("developerName", developerName);
    params.put("traffic", traffic);
    params.put("equipment", equipment);
    params.put("siteArea", siteArea);
    params.put("buildArea", buildArea);
    params.put("ratio", ratio);
    params.put("greenRate", greenRate);
    params.put("carRate", carRate);
    params.put("buildingCnt", buildingCnt);
    params.put("roomCnt", roomCnt);
    params.put("propertyFee", propertyFee);
    params.put("propertyName", propertyName);
    params.put("description", description);
    params.put("linkerPhone", linkerPhone);
    params.put("operator", operator);
    return super.sqlSessionCommon.update("LoupanMapper.update", params);
  }
}
