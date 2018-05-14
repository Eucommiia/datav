package com.juncdt.datav.dao;

import com.juncdt.datav.model.AdTrand;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/14 15:47
 */
@Mapper
public interface AdTrandMapper {

   List<AdTrand> queryTrend();

}
