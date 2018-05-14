package com.juncdt.datav.model;

import javax.persistence.Table;

/**
 * 采集广告总量model
 *
 * @author Luffy
 * @create 2018/5/10 14:24
 */
@Table(name = "ad_total")
public class AdTotal {

   /**
    * id
    */
   private Integer id;
   /**
    * 广告分布类型
    */
   private String adDistribution;
   /**
    * 类型数量
    */
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

   @Override
   public String toString() {
      return "AdTotalVO{" + "id=" + id + ", adDistribution='" + adDistribution + '\'' + ", adNum='"
          + adNum + '\'' + '}';
   }
}
