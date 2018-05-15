package com.juncdt.datav.dao;

import com.juncdt.datav.model.MapModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 地图
 *
 * @author Luffy
 * @create 2018/5/15 10:41
 */
@Mapper
public interface MapMapper {

   /**
    * 查询地图数据
    *
    * @return
    */
   List<MapModel> queryMap();

}
