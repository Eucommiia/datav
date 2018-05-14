package com.juncdt.datav.dao;

import com.juncdt.datav.model.AdMedium;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/14 15:57
 */
@Mapper
public interface AdmediumMapper
{


   List<AdMedium> queryAdMedium();

}
