package com.juncdt.datav.model;


/**
 * 类别分布
 *
 * @author Luffy
 * @create 2018/5/10 15:33
 */
public class AdTypeModel {

   private Integer id;
   private String value;
   private String  name;
   private String color;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }
}
