package com.dtoa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dtoa.model.XCtraveltravel;
import com.dtoa.service.XCtraveltravelService;
import com.dtoa.test.Information;
import com.dtoa.test.units;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("根据条件获取信息")
@Controller
@RequestMapping(value = "universal")
public class universalController {

    @Autowired
    private XCtraveltravelService service;

    @RequestMapping(value = "tiaoqu", method = {RequestMethod.POST})
    @ResponseBody
    public String tiaoqu(String aa) {
        XCtraveltravel tt = new XCtraveltravel();
        tt.setApproval( aa );
        service.inserts( tt );
        System.out.println( "调取成功" + aa );
        return "aaa";
    }

    //    loadPrjs   query     获取项目信息
    @ApiOperation(value = "根据条件项目信息")
    @RequestMapping(value = "project", method = {RequestMethod.GET})
    @ResponseBody
    public Object project(String parameters) {
        Information inf = new Information();
        String method = "loadPrjs";
        Object map = inf.projectname( parameters, method );
        return JSON.toJSONString( map );
    }

    //    syncEmp    queryEmp  获取人员信息
    @ApiOperation(value = "根据条件人员信息")
    @RequestMapping(value = "personnel", method = {RequestMethod.POST})
    @ResponseBody
    public String personnel(String parameters) {
        Information inf = new Information();
        String method = "syncEmp";
        inf.projectname( parameters, method );
        String renyuan = inf.projectname( parameters, method ).toString();
        return renyuan;
    }

    //    findXZCmp  fodemp   获取行政单位
    @ApiOperation(value = "根据条件获取行政单位")
    @RequestMapping(value = "administrative", method = {RequestMethod.GET})
    @ResponseBody
    public List administrative(String parameters) {

        Information inf = new Information();
        String methods = "findXZCmp";
        inf.projectname( parameters, methods );
        JSONArray detailBeans = (JSONArray) inf.projectname( parameters, methods );
        List<String> list = new ArrayList<>();
        for (int i = 0; i < detailBeans.size(); i++) {
            JSONObject object = detailBeans.getJSONObject( i );
            String fdeschs = object.getString( "FDESCHS" );
            System.out.println( fdeschs );
            list.add( fdeschs );
        }
        System.out.println( list );
        return list;
    }

    public String admini(String parameters) {
        Information inf = new Information();
        String methods = "findXZCmp";
        inf.projectname( parameters, methods );
        JSONArray detailBeans = (JSONArray) inf.projectname( parameters, methods );
        List<String> list = new ArrayList<>();
        String aa = "";
        for (int i = 0; i < detailBeans.size(); i++) {
            JSONObject object = detailBeans.getJSONObject( i );
            aa = object.getString( "FODCMP" );
            System.out.println( aa );
        }
        return aa;
    }

    @RequestMapping(value = "tongxing", method = {RequestMethod.GET})
    @ResponseBody
    public String tongxing(String parameters) {
        //先获取员工编号
        units units = new units();
        units.units( parameters );
        String bianhao = units.units( parameters );
        return bianhao;
    }


}
