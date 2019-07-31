package com.dtoa.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.dtoa.dao.XCtraveltravelMapper;
import com.dtoa.model.XCtraveltravel;
import com.dtoa.service.XCtraveltravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class XCtraveltravelServiceImpl implements XCtraveltravelService {

    @Resource
    private XCtraveltravelMapper mapper;

    @Override
    public List<XCtraveltravel> query(String approval, String OpenSpStatus, String NodeStatus) {

        return mapper.query( approval, OpenSpStatus, NodeStatus );
    }

    @Override
    public void insert(XCtraveltravel tt) {
        mapper.insert( tt );
    }

    @Override
    public int del(String approval) {
        return mapper.del( approval );
    }

    @Override
    public Object querys(String approval) {
        return mapper.querys( approval );
    }

    @Override
    public void inserts(XCtraveltravel aa) {
        mapper.insertaa( aa );
    }

    @Override
    public XCtraveltravel sel(String approval) {
        return mapper.sel( approval );
    }

    @Override
    public List<XCtraveltravel> querytable(String userid) {
        return mapper.querytable( userid );
    }

    @Override
    public XCtraveltravel queryall(String approval) {
        return mapper.queryall( approval );
    }
}
