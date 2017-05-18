package com.goodlaike.wjw.service.loupan;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodlaike.wjw.dict.AgeLimit;
import com.goodlaike.wjw.dict.DecoItem;
import com.goodlaike.wjw.dict.LayoutType;
import com.goodlaike.wjw.dict.Order;
import com.goodlaike.wjw.dict.StatFunction;
import com.goodlaike.wjw.dict.StructFunction;
import com.goodlaike.wjw.model.Loupan;
import com.goodlaike.wjw.support.FlagSupport;
import com.goodlaike.wjw.utils.EnumUtil;
import com.goodlaike.wjw.view.LoupanDetailView;
import com.goodlaike.wjw.view.LoupanListView;

@Service
public class LoupanService {

  @Autowired
  private LoupanDao loupanDao;

  /**
   * 根据ID 获得楼盘
   *
   * @see LoupanDao#findById(long)
   */
  Loupan findById(long id) {
    return this.loupanDao.findById(id);
  }

  public LoupanDetailView findDetailById(long id) {
    Loupan loupan = this.findById(id);
    if (loupan == null) {
      return null;
    } else {
      LoupanDetailView view = new LoupanDetailView();
      BeanUtils.copyProperties(loupan, view);
      // TODO transfer data
      return view;
    }
  }

  /**
   * 新增楼盘并返回楼盘ID
   * 
   * @see LoupanDao#insert(String, String, String, Double, String, int, int, int, int,int, String,
   *      String, String, Double, Double, Double, Double, String, Integer, Integer, Double, String,
   *      String, String, int)
   */
  public long insert(String name, String cityName, String districtName, Double avgPrice, String address, String statFunctions,
      String structFunctions, String decoItems, String ageLimits, String layouts, String developerName, String traffic, String equipment,
      Double siteArea, Double buildArea, Double ratio, Double greenRate, String carRate, Integer buildingCnt, Integer roomCnt,
      Double propertyFee, String propertyName, String description, String linkerPhone, int operator) {
    return this.loupanDao.insert(name, cityName, districtName, avgPrice, address,
        FlagSupport.enFlag(EnumUtil.valuesOf(StatFunction.class, statFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(StructFunction.class, structFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(DecoItem.class, decoItems, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(AgeLimit.class, ageLimits, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(LayoutType.class, layouts, ",")), developerName, traffic, equipment, siteArea, buildArea,
        ratio, greenRate, carRate, buildingCnt, roomCnt, propertyFee, propertyName, description, linkerPhone, operator);
  }

  /**
   * 更新楼盘
   * 
   * @see LoupanDao#update(long, String, Double, String, int, int, int, int, int, String, String,
   *      String, Double, Double, Double, Double, String, Integer, Integer, Double, String, String,
   *      String, int)
   */
  public boolean update(long id, String districtName, Double avgPrice, String address, String statFunctions, String structFunctions,
      String decoItems, String ageLimits, String layouts, String developerName, String traffic, String equipment, Double siteArea,
      Double buildArea, Double ratio, Double greenRate, String carRate, Integer buildingCnt, Integer roomCnt, Double propertyFee,
      String propertyName, String description, String linkerPhone, int operator) {
    return this.loupanDao.update(id, districtName, avgPrice, address,
        FlagSupport.enFlag(EnumUtil.valuesOf(StatFunction.class, statFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(StructFunction.class, structFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(DecoItem.class, decoItems, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(AgeLimit.class, ageLimits, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(LayoutType.class, layouts, ",")), developerName, traffic, equipment, siteArea, buildArea,
        ratio, greenRate, carRate, buildingCnt, roomCnt, propertyFee, propertyName, description, linkerPhone, operator) == 1;
  }

  /**
   * 逻辑删除楼盘
   * 
   * @see LoupanDao#delete(long, int)
   */
  public boolean delete(long id, int operator) {
    return this.loupanDao.delete(id, operator) == 1;
  }

  /**
   * 分页查询
   * 
   * @see LoupanDao#findList(int, String, String, String, Integer, String)
   */
  public List<LoupanListView> findList(int pageNo, String name, String cityName, String districtName, String layouts, String order) {
    if (pageNo <= 0) {
      pageNo = 1;
    }
    String orderStr = null;
    if (order != null) {
      switch (Order.valueOf(order)) {
        case 最近更新:
          orderStr = "updateTime desc";
          break;
        case 按均价从高到低:
          orderStr = "avgPrice desc";
          break;
        case 按均价从低到高:
          orderStr = "avgPrice asc";
          break;
      }
    }
    return this.loupanDao.findList(pageNo, name, cityName, districtName,
        FlagSupport.enFlag(EnumUtil.valuesOf(LayoutType.class, layouts, ",")), orderStr);
  }
}
