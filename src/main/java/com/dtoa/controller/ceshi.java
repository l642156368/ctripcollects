package com.dtoa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dtoa.model.XCtraveltravel;
import com.dtoa.service.XCtravelcallbacksService;
import com.dtoa.service.XCtraveltravelService;
import com.dtoa.util.RestfulUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "ceshi")
public class ceshi {


    @Autowired
    private XCtraveltravelService service;


    @RequestMapping(value = "/query", method = {RequestMethod.POST})
    public int insert(String approval) {
        RestfulUtil util = new RestfulUtil();
        Object cha = service.querys( approval );
        System.out.println( cha );
        if (cha != null) {
            String myJsonObj = JSON.toJSONString( cha );
            JSONObject jsonObject = JSON.parseObject( myJsonObj );
            util.setTotal( 1 );
            util.setData( jsonObject );
            util.setStep( 1 );
            util.setError_code( 0 );
            util.setMsg( "查询" );
        } else {
            String myJsonObj = JSON.toJSONString( cha );
            JSONObject jsonObject = JSON.parseObject( myJsonObj );
            util.setTotal( 1 );
            util.setData( jsonObject );
            util.setStep( 1 );
            util.setError_code( 1 );
            util.setMsg( "数据有错误！" );
        }
        return 0;
    }

}

