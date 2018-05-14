package com.juncdt.datav.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 广告量分布实体类
 *
 * @author Luffy
 * @create 2018/5/14 10:02
 */
public class AdNum {

   private Integer id;
   private String name;
   private String num;
   private String type;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getNum() {
      return num;
   }

   public void setNum(String num) {
      this.num = num;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "AdNum{" + "id=" + id + ", name='" + name + '\'' + ", num='" + num + '\'' + ", type='"
          + type + '\'' + '}';
   }
}
