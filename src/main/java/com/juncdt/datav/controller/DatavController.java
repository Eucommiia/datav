package com.juncdt.datav.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juncdt.datav.common.ResultModel;
import com.juncdt.datav.model.AcquisitionTrendModel;
import com.juncdt.datav.model.AdAddModel;
import com.juncdt.datav.model.AdMediumModel;
import com.juncdt.datav.model.AdMediumTwoModel;
import com.juncdt.datav.model.AdNumModel;
import com.juncdt.datav.model.AdTrandModel;
import com.juncdt.datav.model.AdTypeModel;
import com.juncdt.datav.model.AreaTypeModel;
import com.juncdt.datav.model.IndustryDistributionModel;
import com.juncdt.datav.model.MapModel;
import com.juncdt.datav.model.vo.AdTotalVO;
import com.juncdt.datav.service.DatavService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Datav接口API
 *
 * @author Luffy
 * @create 2018/5/10 14:41
 */
@RestController
@RequestMapping(value = "/datav")
public class DatavController {

   @Autowired
   private DatavService datavService;

   /**
    * 采集广告总量
    */
   @PostMapping(value = "/adTotal")
   public ResultModel getAdTotal() {
      List<AdTotalVO> adTotal = datavService.getAdTotal();
      JSONObject jsonAd = new JSONObject();
      for (AdTotalVO ad : adTotal) {
         jsonAd.put(ad.getAdDistribution(), ad.getAdNum());
      }
      return ResultModel.success(jsonAd);
   }

   /**
    * 类型分布
    */
   @PostMapping(value = "/adType")
   public ResultModel getAdType() {
      List<AdTypeModel> adTypeModel = datavService.getAdType();
      JSONArray json = new JSONArray();
      for (int i = 0; i < adTypeModel.size(); i++) {
         JSONObject jsonType = new JSONObject();
         jsonType.put("value", adTypeModel.get(i).getValue());
         jsonType.put("name", adTypeModel.get(i).getName());
         jsonType.put("color", adTypeModel.get(i).getColor());
         json.add(jsonType);
      }
      return ResultModel.success(json);
   }

   /**
    * 行业分布
    */
   @PostMapping(value = "/getIndustryDistribution")
   public ResultModel getIndustryDistribution() {
      List<IndustryDistributionModel> industryDistributionModel = datavService.getIndustryDistribution();
      JSONArray jsonArr = new JSONArray();
      for (IndustryDistributionModel id : industryDistributionModel) {
         JSONObject jsonAdType = new JSONObject();
         jsonAdType.put("value", id.getValue());
         jsonAdType.put("name", id.getName());
         jsonAdType.put("color", id.getColor());
         jsonArr.add(jsonAdType);
      }
      return ResultModel.success(jsonArr);
   }

   /**
    * 采集趋势
    */
   @PostMapping(value = "/getAcquisition")
   public ResultModel getAcquisition() {
      List<AcquisitionTrendModel> acquisition = datavService.getAcquisition();
      String[] name = new String[acquisition.size()];
      for (int i = 0; i < acquisition.size(); i++) {
         name[i] = acquisition.get(i).getName();
      }
      // 去除重复的name
      name = distinctArray(name);
      JSONArray jsonArray = new JSONArray();
      for (int j = 0; j < name.length; j++) {
         List<String> values = datavService.getValue(name[j]);
         JSONObject jsonObj = new JSONObject();
         jsonObj.put("name", name[j]);
         jsonObj.put("data", values);
         jsonArray.add(jsonObj);
      }
      return ResultModel.success(jsonArray);
   }

   /**
    * 广告量分布
    */
   @PostMapping(value = "/getAdNum")
   public ResultModel getAdNum() {
      List<AdNumModel> adNumModel = datavService.getAdNum();
      String[] ad = new String[adNumModel.size()];
      for (int i = 0; i < adNumModel.size(); i++) {
         ad[i] = adNumModel.get(i).getName();
      }
      ad = distinctArray(ad);
      // 循环数组
      JSONArray jsonArray = new JSONArray();
      for (int j = 0; j < ad.length; j++) {
         JSONObject jsonObj = new JSONObject();
         List<String> ad1 = datavService.getNum(ad[j]);
         List<String> ad2 = datavService.getType(ad[j]);
         // name
         jsonObj.put("name", ad[j]);
         //
         jsonObj.put("data", ad1);

         // type
         jsonObj.put("y", ad2);
         jsonArray.add(jsonObj);
      }
      return ResultModel.success(jsonArray);
   }

   /**
    * 确认违法违规地区
    */
   @PostMapping(value = "/getAreaType")
   public ResultModel getArea() {
      List<AreaTypeModel> area = datavService.getArea();
      JSONObject jsonObj = new JSONObject();
      JSONObject jsonObj1 = new JSONObject();
      JSONArray jsonArray = new JSONArray();
      JSONArray jsonArray1 = new JSONArray();
      for (int j = 0; j < area.size(); j++) {
         jsonArray.add(area.get(j).getName());
         jsonArray1.add(area.get(j).getNum());
      }
      jsonObj.put("name", "x");
      jsonObj.put("data", jsonArray);

      jsonObj1.put("name", "y");
      jsonObj1.put("data", jsonArray1);
      JSONArray json = new JSONArray();
      json.add(jsonObj);
      json.add(jsonObj1);
      return ResultModel.success(json);
   }

   /**
    * 采集广告总量
    */
   @PostMapping(value = "/getTrend")
   public ResultModel getTrend() {
      List<AdTrandModel> trend = datavService.getTrend();
      JSONObject jsonAd = new JSONObject();
      for (AdTrandModel ad : trend) {
         jsonAd.put(ad.getAdDistribution(), ad.getAdNum());
      }
      return ResultModel.success(jsonAd);
   }

   /**
    * 确认违法违规媒介分布(左)
    */
   @PostMapping(value = "/getAdMedium")
   public ResultModel getAdMedium() {
      List<AdMediumModel> area = datavService.getAdMedium();
      JSONObject jsonObj = new JSONObject();
      JSONObject jsonObj1 = new JSONObject();
      JSONArray jsonArray = new JSONArray();
      JSONArray jsonArray1 = new JSONArray();
      for (int j = 0; j < area.size(); j++) {
         jsonArray.add(area.get(j).getAdDistribution());
         jsonArray1.add(area.get(j).getAdNum());
      }
      jsonObj.put("name", "y");
      jsonObj.put("data", jsonArray);

      jsonObj1.put("name", "x");
      jsonObj1.put("data", jsonArray1);
      JSONArray json = new JSONArray();
      json.add(jsonObj);
      json.add(jsonObj1);
      return ResultModel.success(json);
   }

   /**
    * 确认违法违规媒介分布(右)
    */
   @PostMapping(value = "/getAdMediumTwo")
   public ResultModel getAdMediumTwo() {
      List<AdMediumTwoModel> adMediumTwoModel = datavService.getAdMediumTwo();
      JSONArray jsonArr = new JSONArray();
      for (AdMediumTwoModel ad : adMediumTwoModel) {
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("name", ad.getName());
         jsonObject.put("value", ad.getValue());
         jsonArr.add(jsonObject);
      }
      return ResultModel.success(jsonArr);

   }

   /**
    * 采集监测范围
    */
   @PostMapping(value = "/getAdTotalAdd")
   public ResultModel getAdTotalAdd() {
      List<AdAddModel> adTotalAdd = datavService.getAdTotalAdd();
      JSONArray jsonArr = new JSONArray();
      for (AdAddModel ad : adTotalAdd) {
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("name", ad.getAdDistribution());
         jsonObject.put("num", ad.getAdNum());
         jsonObject.put("added", "");
         jsonArr.add(jsonObject);
      }
      return ResultModel.success(jsonArr);


   }

   /**
    * 地图
    *
    * @return
    */
   @PostMapping(value = "/getMap")
   public ResultModel getMap() {
      List<MapModel> mapModels =  datavService.getMap();
      JSONObject jsonMap = new JSONObject();
      JSONObject json = new JSONObject();
      JSONArray jsonArr1 = new JSONArray();
      for(MapModel ma : mapModels){
         JSONArray jsonArr = new JSONArray();
         jsonArr.add(ma.getLng());
         jsonArr.add(ma.getLat());
         json.put(ma.getCity(),jsonArr);
         JSONObject jsonObj = new JSONObject();
         jsonObj.put("name",ma.getCity());
         jsonObj.put("value",ma.getValue());
         jsonArr1.add(jsonObj);
      }
      jsonMap.put("geoCoordMap",json);
      jsonMap.put("dataFormat","佛山");
      jsonMap.put("data",jsonArr1);
   return ResultModel.success(jsonMap);
   }


   /**
    * 数组去重
    *
    * @param array 数组
    * @return 数组去重
    */
   private String[] distinctArray(String[] array) {
      Set<String> set = new HashSet<>();
      for (int i = 0; i < array.length; i++) {
         set.add(array[i]);
      }
      return (String[]) set.toArray(new String[set.size()]);
   }

}
