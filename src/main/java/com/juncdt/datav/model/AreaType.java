package com.juncdt.datav.model;

/**
 * 确认违法违规地区
 *
 * @author Luffy
 * @create 2018/5/14 11:19
 */
public class AreaType {

   private Integer id;
   private String name;
   private String num;

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

   @Override
   public String toString() {
      return "AreaType{" + "id=" + id + ", name='" + name + '\'' + ", num='" + num + '\'' + '}';
   }
}
