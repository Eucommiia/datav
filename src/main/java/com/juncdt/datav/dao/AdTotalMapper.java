package com.juncdt.datav.dao;

import com.juncdt.datav.model.vo.AdTotalVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 查询采集广告总量分布
 *
 * @author Luffy
 * @create 2018/5/10 14:36
 */
@Mapper
public interface AdTotalMapper {

   /**
    * 查询采集广告总量分布
    */
   List<AdTotalVO> queryAdTotal();

}
