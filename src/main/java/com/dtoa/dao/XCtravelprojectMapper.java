package com.dtoa.dao;

import com.dtoa.model.XCtravelproject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XCtravelprojectMapper {
    int insert(XCtravelproject record);

    int insertSelective(XCtravelproject record);

    int del(String approval);

    XCtravelproject sel(@Param("approval") String approval);
}
