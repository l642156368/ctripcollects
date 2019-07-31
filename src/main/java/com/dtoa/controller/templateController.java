package com.dtoa.controller;

import com.dtoa.model.XCtraveltemplate;
import com.dtoa.model.XCtraveltravel;
import com.dtoa.service.XCtemplateService;
import com.dtoa.util.RestfulUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "template")
public class templateController {

    @Resource
    private XCtemplateService service;

    /**
     * 判断所属部门
     *
     * @return 对应的模板ID
     */
    @RequestMapping(value = "/querytemp", method = {RequestMethod.POST})
    public XCtraveltemplate querytable(@RequestBody String company) {
        // public XCtraveltemplate querytable (String  acompan) {
        XCtraveltemplate tte = new XCtraveltemplate();
        System.out.println( "接受" + company );
/*
        String acompan = company.get( "company" ).toString();
        System.out.println(tte.getTemplateid());
        System.out.println("转换后"+acompan);*/


        if (company != "" && tte.getTemplateid() == null) {
            int aa = company.indexOf( "待定" );
            if (aa != -1) {
                String tempid = "2";
                tte = service.queryall( tempid );
                System.out.println( "待定" );
            }
        }

        if (company != "" && tte.getTemplateid() == null) {
            int aa = company.indexOf( "特云" );
            if (aa != -1) {
                String tempid = "3";
                tte = service.queryall( tempid );
                System.out.println( "特云" );
            }
        }
        if (company != "") {
            if (company.indexOf( "总经办" ) != -1 || company.indexOf( "支持中心" ) != -1 || company.indexOf( "产品事业部" ) != -1) {
                String tempid = "4";
                tte = service.queryall( tempid );
                System.out.println( tte.getTemplateid() );
                System.out.println( "至高" );
            }
        }


        if (company != "" && tte.getTemplateid() == null) {
            int aa = company.indexOf( "东华云计算有限公司/待定" );
            if (aa != -1) {
                String tempid = "2";
                tte = service.queryall( tempid );
                System.out.println( "东华云计算有限公司/待定" );
            }
        }

        if (company != "" && tte.getTemplateid() == null) {
            int aa = company.indexOf( "东华云计算有限公司/云产/特云" );
            if (aa != -1) {
                String tempid = "3";
                tte = service.queryall( tempid );
                System.out.println( "东华云计算有限公司/云产/特云" );
            }
        }


        if (company != "") {
            if (company.indexOf( "东华云计算有限公司/云产/至云/总经办" ) != -1 || company.indexOf( "东华云计算有限公司/云产/至云/支持中心" ) != -1 || company.indexOf( "东华云计算有限公司/云产/至云/产品事业群" ) != -1) {
                String tempid = "4";
                tte = service.queryall( tempid );
                System.out.println( tte.getTemplateid() );
                System.out.println( "至高" );
            }
        }


        if (company != "" && tte.getTemplateid() == null) {
            String tempid = "1";
            tte = service.queryall( tempid );
            System.out.println( "通用" );
        }


        return tte;
    }

    @RequestMapping(value = "query", method = {RequestMethod.POST})
    private XCtraveltemplate query(@RequestBody String company) {

        XCtraveltemplate aa = service.query( company );
        System.out.println( aa );
        return aa;
    }

    @RequestMapping(value = "insert", method = {RequestMethod.POST})
    private int insert(XCtraveltemplate tt) {
        tt.getTempdescribe();
        tt.getTemplateid();
        tt.getDepartment();
        tt.getTempname();
        tt.setTempid( UUID.randomUUID().toString().replace("-", "") );

        return  service.insert(tt);
    }

}
