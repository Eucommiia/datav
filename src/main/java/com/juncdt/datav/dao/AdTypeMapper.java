package com.juncdt.datav.dao;

import com.juncdt.datav.model.AdType;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类别分布
 *
 * @author Luffy
 * @create 2018/5/10 15:42
 */
@Mapper
public interface AdTypeMapper {

   List<AdType> queryAdType();



}
