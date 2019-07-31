package com.dtoa.service.Impl;

import com.dtoa.dao.XCtraveltemplateMapper;
import com.dtoa.model.XCtraveltemplate;
import com.dtoa.service.XCtemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XCtemplateServiceImpl implements XCtemplateService {


    @Resource
    private XCtraveltemplateMapper mapper;

    @Override
    public List<XCtraveltemplate> querytemp() {
        return mapper.querytemp();
    }

    @Override
    public XCtraveltemplate queryall(String tempid) {
        return mapper.queryall( tempid );
    }

    @Override
    public XCtraveltemplate query(String company) {
        return mapper.query( company );
    }


}
