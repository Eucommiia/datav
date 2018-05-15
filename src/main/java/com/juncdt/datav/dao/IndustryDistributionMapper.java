package com.juncdt.datav.dao;

import com.juncdt.datav.model.IndustryDistributionModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/11 9:19
 */
@Mapper
public interface IndustryDistributionMapper {

   /**
    * 行业分布
    *
    * @return
    */
   List<IndustryDistributionModel> queryIndustryDistribution();

}
