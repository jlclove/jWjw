package com.goodlaike.wjw.service.loupan;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodlaike.wjw.dict.AgeLimit;
import com.goodlaike.wjw.dict.DecoItem;
import com.goodlaike.wjw.dict.Flag;
import com.goodlaike.wjw.dict.LayoutType;
import com.goodlaike.wjw.dict.Order;
import com.goodlaike.wjw.dict.StatFunction;
import com.goodlaike.wjw.dict.StructFunction;
import com.goodlaike.wjw.model.Loupan;
import com.goodlaike.wjw.model.LoupanPicture;
import com.goodlaike.wjw.model.Pagination;
import com.goodlaike.wjw.support.FlagSupport;
import com.goodlaike.wjw.utils.EnumUtil;
import com.goodlaike.wjw.view.LoupanDetailView;
import com.goodlaike.wjw.view.LoupanListView;

@Service
public class LoupanService {

  @Autowired
  private LoupanDao loupanDao;

  @Autowired
  private LoupanPictureService loupanPictureService;

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
      view.setLoupan(loupan);
      view.setPicMap(this.loupanPictureService.findByLoupanId(id).stream().collect(Collectors.groupingBy(LoupanPicture::getType)));
      view.setAgeLimitList(FlagSupport.deFlag(loupan.getAgeLimits(), AgeLimit.class));
      view.setDecoItemList(FlagSupport.deFlag(loupan.getDecoItems(), DecoItem.class));
      view.setFlagList(FlagSupport.deFlag(loupan.getFlag(), Flag.class));
      view.setLayoutTypeList(FlagSupport.deFlag(loupan.getLayouts(), LayoutType.class));
      view.setStatFunctionList(FlagSupport.deFlag(loupan.getStatFunctions(), StatFunction.class));
      view.setStructFunctionList(FlagSupport.deFlag(loupan.getStructFunctions(), StructFunction.class));
      return view;
    }
  }

  /**
   * 新增楼盘并返回楼盘ID
   * 
   * @see LoupanDao#insert(String, String, String, Double, String, int, int, int, int,int, String,
   *      String, String, Double, Double, Double, Double, String, Integer, Integer, Double, String,
   *      String, String, int,int)
   */
  public long insert(String name, String cityName, String districtName, Double avgPrice, String address, String statFunctions,
      String structFunctions, String decoItems, String ageLimits, String layouts, String developerName, String traffic, String equipment,
      Double siteArea, Double buildArea, Double ratio, Double greenRate, String carRate, Integer buildingCnt, Integer roomCnt,
      Double propertyFee, String propertyName, String description, String linkerPhone, String flags, int operator) {
    return this.loupanDao.insert(name, cityName, districtName, avgPrice, address,
        FlagSupport.enFlag(EnumUtil.valuesOf(StatFunction.class, statFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(StructFunction.class, structFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(DecoItem.class, decoItems, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(AgeLimit.class, ageLimits, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(LayoutType.class, layouts, ",")), developerName, traffic, equipment, siteArea, buildArea,
        ratio, greenRate, carRate, buildingCnt, roomCnt, propertyFee, propertyName, description, linkerPhone,
        FlagSupport.enFlag(EnumUtil.valuesOf(Flag.class, flags, ",")), operator);
  }

  /**
   * 更新楼盘
   * 
   * @see LoupanDao#update(long, String, Double, String, int, int, int, int, int, String, String,
   *      String, Double, Double, Double, Double, String, Integer, Integer, Double, String, String,
   *      String, int)
   */
  public boolean update(long id, String name, String cityName, String districtName, Double avgPrice, String address, String statFunctions, String structFunctions,
      String decoItems, String ageLimits, String layouts, String developerName, String traffic, String equipment, Double siteArea,
      Double buildArea, Double ratio, Double greenRate, String carRate, Integer buildingCnt, Integer roomCnt, Double propertyFee,
      String propertyName, String description, String linkerPhone, String flags, int operator) {
    return this.loupanDao.update(id, name, cityName, districtName, avgPrice, address,
        FlagSupport.enFlag(EnumUtil.valuesOf(StatFunction.class, statFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(StructFunction.class, structFunctions, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(DecoItem.class, decoItems, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(AgeLimit.class, ageLimits, ",")),
        FlagSupport.enFlag(EnumUtil.valuesOf(LayoutType.class, layouts, ",")), developerName, traffic, equipment, siteArea, buildArea,
        ratio, greenRate, carRate, buildingCnt, roomCnt, propertyFee, propertyName, description, linkerPhone,
        FlagSupport.enFlag(EnumUtil.valuesOf(Flag.class, flags, ",")), operator) == 1;
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
   * @see LoupanDao#findList(int,int String, String, String, Integer, String)
   */
  public List<LoupanListView> findList(int pageNo, int pageSize, String name, String cityName, String districtName, String layouts,
      String order) {
    if (pageNo <= 0) {
      pageNo = 1;
    }
    if (pageSize <= 0) {
      pageSize = 20;
    }
    String orderStr = null;
    if (order != null) {
      switch (Order.valueOf(order)) {
        case 默认:
          break;
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
    List<LoupanListView> list = this.loupanDao.findList(pageNo, pageSize, name, cityName, districtName,
        FlagSupport.enFlag(EnumUtil.valuesOf(LayoutType.class, layouts, ",")), orderStr);
    list.forEach((view) -> view.setLayoutTypeList(FlagSupport.deFlag(view.getLayouts(), LayoutType.class)));
    return list;
  }

  /**
   * 分页查询总数
   * 
   * @see LoupanDao#findListCount( String, String, String, Integer)
   */
  public long findListCount(String name, String cityName, String districtName, String layouts) {
    return this.loupanDao.findListCount(name, cityName, districtName,
        FlagSupport.enFlag(EnumUtil.valuesOf(LayoutType.class, layouts, ",")));
  }


  /**
   * 分页查询
   * 
   */
  public Pagination findPagination(int pageNo, int pageSize, String name, String cityName, String districtName, String layouts,
      String order) {
    if (pageNo <= 0) {
      pageNo = 1;
    }
    if (pageSize <= 0) {
      pageSize = 20;
    }
    Pagination page = new Pagination();
    page.setList(this.findList(pageNo, pageSize, name, cityName, districtName, layouts, order));
    page.setTotalRecords(this.findListCount(name, cityName, districtName, layouts));
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    return page;
  }
}
