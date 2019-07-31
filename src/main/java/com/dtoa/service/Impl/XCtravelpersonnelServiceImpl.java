package com.dtoa.service.Impl;

import com.dtoa.dao.XCtravelpersonnelMapper;
import com.dtoa.model.XCtravelpersonnel;
import com.dtoa.service.XCtravelpersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XCtravelpersonnelServiceImpl implements XCtravelpersonnelService {
    @Resource
    private XCtravelpersonnelMapper mapper;

    @Override
    public void insert(XCtravelpersonnel tep) {
        mapper.insert( tep );
    }

    @Override
    public int del(String approval) {
        return mapper.del( approval );
    }

    @Override
    public XCtravelpersonnel sel(String approval) {
        return mapper.sel( approval );
    }
}
