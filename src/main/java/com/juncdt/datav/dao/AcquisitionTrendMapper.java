package com.juncdt.datav.dao;

import com.juncdt.datav.model.AcquisitionTrend;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/11 9:36
 */
@Repository
@Mapper
public interface AcquisitionTrendMapper {

   /**
    *
    * @return
    */

   List<AcquisitionTrend> queryAcquisitionTrend();

   /**
    *
    * @param name
    * @return
    */
   List<String>  queryValue(@Param("name")String name);

}
