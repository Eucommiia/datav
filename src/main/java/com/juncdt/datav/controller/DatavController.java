package com.juncdt.datav.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juncdt.datav.common.ResultModel;
import com.juncdt.datav.model.AcquisitionTrend;
import com.juncdt.datav.model.AdAdd;
import com.juncdt.datav.model.AdMedium;
import com.juncdt.datav.model.AdMediumTwo;
import com.juncdt.datav.model.AdNum;
import com.juncdt.datav.model.AdTrand;
import com.juncdt.datav.model.AdType;
import com.juncdt.datav.model.AreaType;
import com.juncdt.datav.model.IndustryDistribution;
import com.juncdt.datav.model.vo.AdTotalVO;
import com.juncdt.datav.service.DatavService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
      List<AdType> adType = datavService.getAdType();
      JSONArray json = new JSONArray();
      for (int i = 0; i < adType.size(); i++) {
         JSONObject jsonType = new JSONObject();
         jsonType.put("value", adType.get(i).getValue());
         jsonType.put("name", adType.get(i).getName());
         jsonType.put("color", adType.get(i).getColor());
         json.add(jsonType);
      }
      return ResultModel.success(json);
   }

   /**
    * 行业分布
    */
   @PostMapping(value = "/getIndustryDistribution")
   public ResultModel getIndustryDistribution() {
      List<IndustryDistribution> industryDistribution = datavService.getIndustryDistribution();
      JSONArray jsonArr = new JSONArray();
      for (IndustryDistribution id : industryDistribution) {
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
      List<AcquisitionTrend> acquisition = datavService.getAcquisition();
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
      List<AdNum> adNum = datavService.getAdNum();
      String[] ad = new String[adNum.size()];
      for (int i = 0; i < adNum.size(); i++) {
         ad[i] = adNum.get(i).getName();
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
      List<AreaType> area = datavService.getArea();
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
      jsonObj1.put("data",jsonArray1);
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
      List<AdTrand> trend = datavService.getTrend();
      JSONObject jsonAd = new JSONObject();
      for (AdTrand ad : trend) {
         jsonAd.put(ad.getAdDistribution(), ad.getAdNum());
      }
      return ResultModel.success(jsonAd);
   }

   /**
    *
    * @return
    */
   @PostMapping(value = "/getAdMedium")
   public ResultModel getAdMedium() {
      List<AdMedium> area = datavService.getAdMedium();
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
      jsonObj1.put("data",jsonArray1);
      JSONArray json = new JSONArray();
      json.add(jsonObj);
      json.add(jsonObj1);
      return ResultModel.success(json);
   }

   @PostMapping(value = "/getAdMediumTwo")
   public ResultModel getAdMediumTwo(){
      List<AdMediumTwo> adMediumTwo = datavService.getAdMediumTwo();
      JSONArray jsonArr = new JSONArray();
      for(AdMediumTwo ad :adMediumTwo){
         JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",ad.getName());
            jsonObject.put("value",ad.getValue());
            jsonArr.add(jsonObject);
      }
      return  ResultModel.success(jsonArr);

   }

   /**
    * 采集监测范围
    *
    * @return
    */
   @PostMapping(value = "/getAdTotalAdd")
   public ResultModel getAdTotalAdd(){
      List<AdAdd> adTotalAdd = datavService.getAdTotalAdd();
      JSONArray jsonArr = new JSONArray();
      for(AdAdd ad :adTotalAdd){
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("name",ad.getAdDistribution());
         jsonObject.put("num",ad.getAdNum());
         jsonObject.put("added","");
         jsonArr.add(jsonObject);
      }
      return  ResultModel.success(jsonArr);


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
