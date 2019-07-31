package com.dtoa.dao;

import com.dtoa.model.XCtraveltemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XCtraveltemplateMapper {
    int deleteByPrimaryKey(String tempid);

    int insert(XCtraveltemplate record);

    int insertSelective(XCtraveltemplate record);

    XCtraveltemplate selectByPrimaryKey(String tempid);

    int updateByPrimaryKeySelective(XCtraveltemplate record);

    int updateByPrimaryKey(XCtraveltemplate record);

    List<XCtraveltemplate> querytemp();

    XCtraveltemplate queryall(String tempid);

    XCtraveltemplate query(String company);

}
