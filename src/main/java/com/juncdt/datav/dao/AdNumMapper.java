package com.juncdt.datav.dao;

import com.juncdt.datav.model.AdNumModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/14 10:06
 */
@Mapper
public interface AdNumMapper {

   List<AdNumModel> queryAdNum();

   List<String> queryNum(@Param("name") String name);
   List<String> queryType(@Param("name") String name);
}
