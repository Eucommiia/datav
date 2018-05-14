package com.juncdt.datav.model;

/**
 * 监测采集范围
 *
 * @author Luffy
 * @create 2018/5/14 11:28
 */
public class AdAdd {
   private Integer id;
   private String adDistribution;
   private String adNum;
   private String added;

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

   public String getAdded() {
      return added;
   }

   public void setAdded(String added) {
      this.added = added;
   }
}
