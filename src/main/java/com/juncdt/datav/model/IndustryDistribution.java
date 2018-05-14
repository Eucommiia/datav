package com.juncdt.datav.model;

/**
 * 行业分布
 *
 * @author Luffy
 * @create 2018/5/11 9:15
 */
public class IndustryDistribution {

   private Integer id;

   private String name;

   private String value;

   private String color;

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

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }
}
