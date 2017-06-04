package com.goodlaike.wjw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodlaike.wjw.service.loupan.LoupanService;
import com.goodlaike.wjw.view.LoupanDetailView;
import com.goodlaike.wjw.view.LoupanListView;

@RestController
public class LoupanController extends BaseController {

  @Autowired
  private LoupanService loupanService;

  /**
   * 新增楼盘并返回楼盘ID
   * 
   * @see LoupanService#insert(String, String, String, Double, String, String, String, String,
   *      String, String, String, String, String, Double, Double, Double, Double, String, Integer,
   *      Integer, Double, String, String, String, int)
   */
  @RequestMapping(value = "/admin/loupan", method = RequestMethod.POST)
  public long insert(@RequestParam(value = "name", required = true) String name,
      @RequestParam(value = "cityName", required = true) String cityName,
      @RequestParam(value = "districtName", required = true) String districtName,
      @RequestParam(value = "avgPrice", required = false) Double avgPrice,
      @RequestParam(value = "address", required = false) String address,
      @RequestParam(value = "statFunctions", required = false) String statFunctions,
      @RequestParam(value = "structFunctions", required = false) String structFunctions,
      @RequestParam(value = "decoItems", required = false) String decoItems,
      @RequestParam(value = "ageLimits", required = false) String ageLimits,
      @RequestParam(value = "layouts", required = false) String layouts,
      @RequestParam(value = "developerName", required = false) String developerName,
      @RequestParam(value = "traffic", required = false) String traffic,
      @RequestParam(value = "equipment", required = false) String equipment,
      @RequestParam(value = "siteArea", required = false) Double siteArea,
      @RequestParam(value = "buildArea", required = false) Double buildArea, @RequestParam(value = "ratio", required = false) Double ratio,
      @RequestParam(value = "greenRate", required = false) Double greenRate,
      @RequestParam(value = "carRate", required = false) String carRate,
      @RequestParam(value = "buildingCnt", required = false) Integer buildingCnt,
      @RequestParam(value = "roomCnt", required = false) Integer roomCnt,
      @RequestParam(value = "propertyFee", required = false) Double propertyFee,
      @RequestParam(value = "propertyName", required = false) String propertyName,
      @RequestParam(value = "description", required = false) String description,
      @RequestParam(value = "linkerPhone", required = false) String linkerPhone,
      @RequestParam(value = "flags", required = false) String flags, HttpServletRequest request) {
    return this.loupanService.insert(name, cityName, districtName, avgPrice, address, statFunctions, structFunctions, decoItems, ageLimits,
        layouts, developerName, traffic, equipment, siteArea, buildArea, ratio, greenRate, carRate, buildingCnt, roomCnt, propertyFee,
        propertyName, description, linkerPhone, flags, super.pollLogined(request).getId());
  }

  /**
   * 更新楼盘
   * 
   * @see LoupanService#update(long, String, Double, String, String, String, String, String, String,
   *      String, String, String, Double, Double, Double, Double, String, Integer, Integer, Double,
   *      String, String, String, int)
   */
  @RequestMapping(value = "/admin/loupan/{id}", method = RequestMethod.POST)
  public boolean update(@PathVariable(value = "id") long id, @RequestParam(value = "districtName", required = true) String districtName,
      @RequestParam(value = "avgPrice", required = false) Double avgPrice,
      @RequestParam(value = "address", required = false) String address,
      @RequestParam(value = "statFunctions", required = false) String statFunctions,
      @RequestParam(value = "structFunctions", required = false) String structFunctions,
      @RequestParam(value = "decoItems", required = false) String decoItems,
      @RequestParam(value = "ageLimits", required = false) String ageLimits,
      @RequestParam(value = "layouts", required = false) String layouts,
      @RequestParam(value = "developerName", required = false) String developerName,
      @RequestParam(value = "traffic", required = false) String traffic,
      @RequestParam(value = "equipment", required = false) String equipment,
      @RequestParam(value = "siteArea", required = false) Double siteArea,
      @RequestParam(value = "buildArea", required = false) Double buildArea, @RequestParam(value = "ratio", required = false) Double ratio,
      @RequestParam(value = "greenRate", required = false) Double greenRate,
      @RequestParam(value = "carRate", required = false) String carRate,
      @RequestParam(value = "buildingCnt", required = false) Integer buildingCnt,
      @RequestParam(value = "roomCnt", required = false) Integer roomCnt,
      @RequestParam(value = "propertyFee", required = false) Double propertyFee,
      @RequestParam(value = "propertyName", required = false) String propertyName,
      @RequestParam(value = "description", required = false) String description,
      @RequestParam(value = "linkerPhone", required = false) String linkerPhone,
      @RequestParam(value = "flags", required = false) String flags, HttpServletRequest request) {
    return this.loupanService.update(id, districtName, avgPrice, address, statFunctions, structFunctions, decoItems, ageLimits, layouts,
        developerName, traffic, equipment, siteArea, buildArea, ratio, greenRate, carRate, buildingCnt, roomCnt, propertyFee, propertyName,
        description, linkerPhone, flags, super.pollLogined(request).getId());
  }

  /**
   * 逻辑删除楼盘
   * 
   * @see LoupanService#delete(long, int)
   */
  @RequestMapping(value = "/admin/loupan/{id}", method = RequestMethod.DELETE)
  public boolean delete(@PathVariable(value = "id") long id, HttpServletRequest request) {
    return this.loupanService.delete(id, super.pollLogined(request).getId());
  }

  /**
   * 分页查询
   * 
   * @see LoupanService#findList(int, String, String, String, String, String)
   */
  @RequestMapping(value = "/api/loupan", method = RequestMethod.GET)
  public List<LoupanListView> findList(@RequestParam(value = "pageNo", required = true, defaultValue = "1") int pageNo,
      @RequestParam(value = "name", required = false) String name, @RequestParam(value = "cityName", required = false) String cityName,
      @RequestParam(value = "districtName", required = false) String districtName,
      @RequestParam(value = "layouts", required = false) String layouts, @RequestParam(value = "order", required = false) String order) {
    return this.loupanService.findList(pageNo, name, cityName, districtName, layouts, order);
  }

  /**
   * 详情查询
   * 
   * @see LoupanService#findDetailById(long)
   */
  @RequestMapping(value = "/api/loupan/{id}", method = RequestMethod.GET)
  public LoupanDetailView findDetailById(@PathVariable(value = "id") long id) {
    return this.loupanService.findDetailById(id);
  }
}
