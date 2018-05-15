package com.juncdt.datav.dao;

import com.juncdt.datav.model.AdAddModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/14 16:29
 */
@Mapper
public interface AdTotalAddMapper {

   /**
    *
    * @return
    */
   List<AdAddModel> queryTotalAdd();

}
