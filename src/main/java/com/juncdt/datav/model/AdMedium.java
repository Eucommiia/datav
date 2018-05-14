package com.juncdt.datav.model;

/**
 * 认违法违规媒介分布(左)
 *
 * @author Luffy
 * @create 2018/5/14 11:24
 */
public class AdMedium {

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
