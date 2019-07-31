package com.dtoa.service.Impl;

import com.dtoa.dao.testMapper;
import com.dtoa.model.test;
import com.dtoa.service.testservice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class testImpl implements testservice {


    @Resource
    private testMapper mapper;
    @Override
    public List<test> qyery() {
        return mapper.query();
    }

    @Override
    public int del(String a) {
        return mapper.del(a);
    }

    @Override
    public int insert(test test) {
        return mapper.insert( test );
    }

    @Override
    public int update(test test) {
        return mapper.update(test);
    }


}
