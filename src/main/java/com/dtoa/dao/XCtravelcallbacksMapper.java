package com.dtoa.dao;

import com.dtoa.model.XCtravelcallbacks;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XCtravelcallbacksMapper {
    int deleteByPrimaryKey(String thirdno);

    int insert(XCtravelcallbacks record);

    int insertSelective(XCtravelcallbacks record);

    XCtravelcallbacks sel(String thirdno);

    int updateByPrimaryKeySelective(XCtravelcallbacks record);

    int updateByPrimaryKey(XCtravelcallbacks record);

    int query(String thirdNo);
}
