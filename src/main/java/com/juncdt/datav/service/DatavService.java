package com.juncdt.datav.service;

import com.juncdt.datav.dao.AcquisitionTrendMapper;
import com.juncdt.datav.dao.AdNumMapper;
import com.juncdt.datav.dao.AdTotalAddMapper;
import com.juncdt.datav.dao.AdTotalMapper;
import com.juncdt.datav.dao.AdTrandMapper;
import com.juncdt.datav.dao.AdTypeMapper;
import com.juncdt.datav.dao.AdmediumMapper;
import com.juncdt.datav.dao.AdmediumTwoMapper;
import com.juncdt.datav.dao.AreaTypeMapper;
import com.juncdt.datav.dao.IndustryDistributionMapper;
import com.juncdt.datav.dao.MapMapper;
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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DataVService
 *
 * @author Luffy
 * @create 2018/5/10 14:37
 */
@Service
public class DatavService {


   @Autowired
   private AdTotalMapper adTotalMapper;

   @Autowired
   private AdTypeMapper adTypeMapper;

   @Autowired
   private IndustryDistributionMapper industryDistributionMapper;

   @Autowired
   private AcquisitionTrendMapper acquisitionTrendMapper;

   @Autowired
   private AdNumMapper adNumMapper;

   @Autowired
   private AreaTypeMapper areaTypeMapper;

   @Autowired
   private AdTrandMapper adTrandMapper;

   @Autowired
   private AdmediumMapper admediumMapper;

   @Autowired
   private AdmediumTwoMapper admediumTwoMapper;

   @Autowired
   private AdTotalAddMapper adTotalAddMapper;

   @Autowired
   private MapMapper mapMapper;

   /**
    * 采集广告总量分布
    *
    * @return 总数
    */
   public List<AdTotalVO> getAdTotal() {
      return adTotalMapper.queryAdTotal();
   }

   /**
    * 类别分布
    *
    * @return 总数
    */
   public List<AdTypeModel> getAdType() {
      return adTypeMapper.queryAdType();
   }


   /**
    * 行业分布
    */
   public List<IndustryDistributionModel> getIndustryDistribution() {
      return industryDistributionMapper.queryIndustryDistribution();
   }

   /**
    * 采集趋势
    */
   public List<AcquisitionTrendModel> getAcquisition() {
      return acquisitionTrendMapper.queryAcquisitionTrend();
   }


   public List<String> getValue(String names) {
      return acquisitionTrendMapper.queryValue(names);
   }

   /**
    * 广告量分布
    */
   public List<AdNumModel> getAdNum() {
      return adNumMapper.queryAdNum();
   }


   public List<String> getNum(String name) {
      return adNumMapper.queryNum(name);
   }

   public List<String> getType(String name) {
      return adNumMapper.queryType(name);
   }


   public List<AreaTypeModel> getArea() {
      return areaTypeMapper.queryAreaType();
   }

   public List<AdTrandModel> getTrend() {
      return adTrandMapper.queryTrend();
   }

   /**
    * .确认违法违规媒介分布(左)
    * @return
    */
   public List<AdMediumModel> getAdMedium(){
      return admediumMapper.queryAdMedium();
   }

   /**
    *.确认违法违规媒介分布(右)
    * @return
    */
   public List<AdMediumTwoModel> getAdMediumTwo(){
      return admediumTwoMapper.queryAdMediumTwo();
   }

   /**
    *.监测采集范围
    *
    * @return
    */
   public List<AdAddModel> getAdTotalAdd(){
      return  adTotalAddMapper.queryTotalAdd();
   }

   public List<MapModel> getMap(){
      return mapMapper.queryMap();
   }
}

