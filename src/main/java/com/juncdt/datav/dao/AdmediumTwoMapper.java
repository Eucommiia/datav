package com.juncdt.datav.dao;

import com.juncdt.datav.model.AdMediumTwo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO Add class description here
 *
 * @author Luffy
 * @create 2018/5/14 16:15
 */
@Mapper
public interface AdmediumTwoMapper {


   List<AdMediumTwo> queryAdMediumTwo();
}
