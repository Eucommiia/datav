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
   public List<AdType> getAdType() {
      return adTypeMapper.queryAdType();
   }


   /**
    * 行业分布
    */
   public List<IndustryDistribution> getIndustryDistribution() {
      return industryDistributionMapper.queryIndustryDistribution();
   }

   /**
    * 采集趋势
    */
   public List<AcquisitionTrend> getAcquisition() {
      return acquisitionTrendMapper.queryAcquisitionTrend();
   }


   public List<String> getValue(String names) {
      return acquisitionTrendMapper.queryValue(names);
   }

   /**
    * 广告量分布
    */
   public List<AdNum> getAdNum() {
      return adNumMapper.queryAdNum();
   }


   public List<String> getNum(String name) {
      return adNumMapper.queryNum(name);
   }

   public List<String> getType(String name) {
      return adNumMapper.queryType(name);
   }


   public List<AreaType> getArea() {
      return areaTypeMapper.queryAreaType();
   }

   public List<AdTrand> getTrend() {
      return adTrandMapper.queryTrend();
   }

   public List<AdMedium> getAdMedium(){
      return admediumMapper.queryAdMedium();
   }


   public List<AdMediumTwo> getAdMediumTwo(){
      return admediumTwoMapper.queryAdMediumTwo();
   }


   public List<AdAdd> getAdTotalAdd(){
      return  adTotalAddMapper.queryTotalAdd();
   }
}

