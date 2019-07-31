package com.dtoa.controller;

import com.dtoa.model.test;
import com.dtoa.service.testservice;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "chaxun")
public class wang {
@Resource
private testservice service;

    @RequestMapping(value="query", method = {RequestMethod.POST})
    private List<test> query(){

        return service.qyery();

    }

    @RequestMapping(value = "del", method = {RequestMethod.POST})
    private int del(@RequestBody Map<String, Object> tt){
       String a = tt.get( "a" ).toString();
       return service.del(a);

    }

    @RequestMapping(value = "insert"  , method = {RequestMethod.POST})
    private  int insert(@RequestBody Map<String, Object> tt){
        test  test = new test();
        String a = tt.get( "a" ).toString();
        String b = tt.get( "b" ).toString();
        String c = tt.get( "c" ).toString();
        test.setC( c );
        test.setB( b );
        test.setA( a );
        return  service.insert(test);

    }

    @RequestMapping(value = "update", method = {RequestMethod.POST})
    private int update(@RequestBody Map<String, Object> tt){
        test  test = new test();
        String a = tt.get( "a" ).toString();
        String b = tt.get( "b" ).toString();
        String c = tt.get( "c" ).toString();
        test.setC( c );
        test.setB( b );
        test.setA( a );
        return service.update(test);
    }

}
