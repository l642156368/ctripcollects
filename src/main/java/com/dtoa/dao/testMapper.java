package com.dtoa.dao;

import com.dtoa.model.test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface testMapper {
    int insert(test record);

    int insertSelective(test record);

    List<test> query();

    int del(String a);

    int update(test test);
}
