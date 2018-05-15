package com.juncdt.datav.dao;

import com.juncdt.datav.model.MapModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/15 10:41
 */
@Mapper
public interface MapMapper {

   List<MapModel> queryMap();

}
