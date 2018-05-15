package com.juncdt.datav.dao;

import com.juncdt.datav.model.AreaTypeModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/14 14:19
 */
@Mapper
public interface AreaTypeMapper {

   /**
    *
    * @return
    */
   List<AreaTypeModel> queryAreaType();

}
