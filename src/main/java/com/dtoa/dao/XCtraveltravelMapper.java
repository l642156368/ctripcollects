package com.dtoa.dao;

import com.alibaba.fastjson.JSONObject;
import com.dtoa.model.XCtraveltravel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface XCtraveltravelMapper {
    int insert(XCtraveltravel tt);

    int insertSelective(XCtraveltravel record);

    List<XCtraveltravel> query(@Param("approval") String approval, @Param("OpenSpStatus") String OpenSpStatus, @Param("NodeStatus") String NodeStatus);

    int del(String approval);

    Object querys(String approval);

    void insertaa(XCtraveltravel aa);

    XCtraveltravel sel(@Param("approval") String approval);

    List<XCtraveltravel> querytable(String userid);

    XCtraveltravel queryall(@Param("approval") String approval);
}
