package com.dtoa.service.Impl;

import com.dtoa.dao.XCtravelprojectMapper;
import com.dtoa.model.XCtravelproject;
import com.dtoa.service.XCtravelprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XCtravelprojectServiceImpl implements XCtravelprojectService {
    @Autowired
    private XCtravelprojectMapper mapper;

    @Override
    public void insert(XCtravelproject tp) {
        mapper.insert( tp );
    }

    @Override
    public int del(String approval) {
        return mapper.del( approval );
    }

    @Override
    public XCtravelproject sel(String approval) {
        return mapper.sel( approval );
    }
}
