package com.dtoa.service.Impl;


import com.dtoa.dao.XCtravelcallbacksMapper;
import com.dtoa.model.XCtravelcallbacks;
import com.dtoa.service.XCtravelcallbacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class XCtravelcallbacksServiceImpl implements XCtravelcallbacksService {
    @Resource
    private XCtravelcallbacksMapper mapper;

    @Override
    public int del(String approval) {
        return mapper.deleteByPrimaryKey( approval );
    }

    @Override
    public void insert(XCtravelcallbacks xc) {
        mapper.insert( xc );
    }

    @Override
    public XCtravelcallbacks sel(String ThirdNo) {
        return mapper.sel( ThirdNo );
    }

    @Override
    public int query(String thirdNo) {
        return mapper.query( thirdNo );
    }

    @Override
    public void updete(XCtravelcallbacks xc) {
        mapper.updateByPrimaryKey( xc );
    }
}
