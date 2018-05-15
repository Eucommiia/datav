package com.juncdt.datav.model;

/**
 * 确认违法违规行业分布
 *
 * @author Luffy
 * @create 2018/5/14 11:20
 */
public class AdTrandModel {

   private Integer id;
   private String adDistribution;
   private String adNum;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getAdDistribution() {
      return adDistribution;
   }

   public void setAdDistribution(String adDistribution) {
      this.adDistribution = adDistribution;
   }

   public String getAdNum() {
      return adNum;
   }

   public void setAdNum(String adNum) {
      this.adNum = adNum;
   }
}
