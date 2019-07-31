package com.dtoa.dao;

import com.dtoa.model.XCtravelpersonnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XCtravelpersonnelMapper {
    int insert(XCtravelpersonnel record);

    int insertSelective(XCtravelpersonnel record);

    int del(String approval);

    XCtravelpersonnel sel(@Param("approval") String approval);
}
