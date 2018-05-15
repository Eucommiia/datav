package com.juncdt.datav.model;

/**
 * 地图Model
 *
 * @author Luffy
 * @create 2018/5/15 10:39
 */
public class MapModel {

   private Integer id;
   private String city;
   private String lng;
   private String lat;
   private String value;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getLng() {
      return lng;
   }

   public void setLng(String lng) {
      this.lng = lng;
   }

   public String getLat() {
      return lat;
   }

   public void setLat(String lat) {
      this.lat = lat;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }
}
