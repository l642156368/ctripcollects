package com.dtoa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dtoa.model.XCtravelcallbacks;
import com.dtoa.model.XCtravelpersonnel;
import com.dtoa.model.XCtravelproject;
import com.dtoa.model.XCtraveltravel;
import com.dtoa.service.XCtravelcallbacksService;
import com.dtoa.service.XCtravelpersonnelService;
import com.dtoa.service.XCtravelprojectService;
import com.dtoa.service.XCtraveltravelService;
import com.dtoa.test.Information;
import com.dtoa.test.uid;
import com.dtoa.util.RestfulUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Api("审批信息查询")
@RestController
@RequestMapping(value = "evection")
public class travelController {
    private static Logger log = LoggerFactory.getLogger( travelController.class );
    @Autowired
    private XCtraveltravelService service;
    @Autowired
    private XCtravelprojectService tpservice;
    @Autowired
    private XCtravelpersonnelService tpeservice;
    @Autowired
    private XCtravelcallbacksService tcService;

    /***
     * 根据订单号查询
     * 未使用
     * @param approval
     * @return
     */
    @RequestMapping(value = "particulars", method = {RequestMethod.POST})
    public List<XCtraveltravel> query(String approval) {
        String OpenSpStatus = "2";
        String NodeStatus = "2";
        List<XCtraveltravel> cha = service.query( approval, OpenSpStatus, NodeStatus );
        return cha;
    }

    @Autowired
    private universalController un;

    /**
     * 审批数据新增
     *
     * @param jobdata
     * @return
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public RestfulUtil insert(@RequestBody String jobdata) {

        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        SimpleDateFormat date = new SimpleDateFormat( "yyyyMMddHHmmsssss" );
        String currenttime = dateFormat.format( new Date() );
        String approval = date.format( new Date() );
        RestfulUtil util = new RestfulUtil();
        JSONObject json = JSON.parseObject( jobdata );
        XCtravelproject tp = new XCtravelproject();
        XCtraveltravel tt = new XCtraveltravel();
        //出行信息
        String applyTime = currenttime;
        //出发城市
        String dep = json.getString( "departure" );
        System.out.println( dep );
        String departure = dep.replace( "\"", "" ).replace( "[", "" ).replace( "]", "" );
        System.out.println( departure );
        //到达城市
        String arr = json.getString( "arrived" );
        String arrived = arr.replace( "\"", "" ).replace( "[", "" ).replace( "]", "" );
        System.out.println( departure );


        String starttime = json.getString( "starttime" );
        String endtime = json.getString( "endtime" );
        String duration = json.getString( "duration" );
        String unit = json.getString( "unit" );
        String company = json.getString( "company" );


        //人员的携程ID
        String pedestrianid = json.getString( "pedestrianid" );
        //行政归属单位ID
        String guishu = un.admini( pedestrianid );
        String unitid = json.getString( guishu );
        String reasons = json.getString( "reasons" );


        String vehicles = json.getString( "vehicles" );

        if ("".equals( vehicles )) {
            tt.setVehicles( "无" );
        } else {
            tt.setVehicles( vehicles );
        }
        String userid = json.getString( "userid" );
        tt.setUserid( userid );
        tt.setApproval( approval );
        tt.setApplytime( applyTime );
        tt.setArrived( arrived );
        tt.setDeparture( departure );
        tt.setEndtime( endtime );
        tt.setDuration( duration );
        tt.setReasons( reasons );
        tt.setStarttime( starttime );
        tt.setUnit( unit );
        tt.setUnitid( unitid );

        tt.setCompany( company );
        service.insert( tt );


        String prnumber = json.getString( "prnumber" );

        String projectname = json.getString( "projectname" );
        if ("".equals( projectname )) {
            tp.setProjectname( "无" );
        } else {
            tp.setProjectname( projectname );
        }


        String sellunit = json.getString( "sellunit" );
        String othersalesid = json.getString( "othersalesid" );
        String department = json.getString( "department" );
        String worktype = json.getString( "worktype" );
        String market = json.getString( "market" );
        String othersales = json.getString( "othersales" );

        tp.setApproval( approval );
        tp.setMarket( market );
        tp.setOthersales( othersales );
        tp.setPrnumber( prnumber );

        tp.setSellunit( sellunit );
        tp.setDepartment( department );
        tp.setOthersalesid( othersalesid );
        tp.setWorktype( worktype );
        tpservice.insert( tp );

        //出行相关人员
        XCtravelpersonnel tep = new XCtravelpersonnel();
        String pedestrian = json.getString( "pedestrian" );
        String with = json.getString( "with" );
        String trekking = json.getString( "trekking" );
        String cc = json.getString( "cc" );
        String withid = json.getString( "withid" );
        String trekkingid = json.getString( "trekkingid" );
        String ccid = json.getString( "ccid" );

        tep.setTrekking( with + trekking + cc );
        tep.setTrekkingid( withid + trekkingid + ccid );

        if ((with != null && trekking != null && cc != null) && (!"".equals( with ) && !"".equals( trekking ) && !"".equals( cc ))) {
            tep.setTrekking( with + "," + trekking + "," + cc );
            tep.setTrekkingid( withid + "," + trekkingid + "," + ccid );
        }

        // 1空 23不空
        if ((with != null && trekking != null) && (!"".equals( with ) && !"".equals( trekking ))) {
            if ("".equals( cc )) {
                tep.setTrekking( with + "," + trekking + cc );
                tep.setTrekkingid( withid + "," + trekkingid + ccid );
            }
        }
        if ((cc != null && trekking != null) && (!"".equals( cc ) && !"".equals( trekking ))) {
            if ("".equals( with )) {
                tep.setTrekking( cc + "," + trekking + with );
                tep.setTrekkingid( ccid + "," + trekkingid + withid );
            }
        }
        if ((with != null && cc != null) && (!"".equals( with ) && !"".equals( cc ))) {
            if ("".equals( trekking )) {
                tep.setTrekking( with + "," + cc + trekking );
                tep.setTrekkingid( withid + "," + ccid + trekkingid );
            }
        }


        if ((with == null && trekking == null && cc == null) || ("".equals( with ) && "".equals( trekking ) && "".equals( cc ))) {
            tep.setTrekking( "无" );
            tep.setTrekkingid( "无" );
        }

        String approvers = json.getString( "approvers" );
        String approversid = json.getString( "approversid" );
        String renews = json.getString( "renews" );
        String renewsid = json.getString( "renewsid" );
        tep.setPedestrian( pedestrian );
        tep.setApproval( approval );
        tep.setPedestrianid( pedestrianid );
        tep.setApprovers( approvers );
        tep.setApproversid( approversid );
        tep.setRenews( renews );
        tep.setRenewsid( renewsid );
        tpeservice.insert( tep );

        List<Object> list = new ArrayList<>();
        list.add( tt );
        list.add( tp );
        list.add( tep );
        Object cha = service.querys( approval );
        if (cha != null) {
            String myJsonObj = JSON.toJSONString( cha );
            JSONObject jsonObject = JSON.parseObject( myJsonObj );
            util.setTotal( 1 );
            util.setData( jsonObject );
            util.setStep( 1 );
            util.setError_code( 0 );
            util.setMsg( "保存成功" );
        } else {
            String myJsonObj = JSON.toJSONString( cha );
            JSONObject jsonObject = JSON.parseObject( myJsonObj );
            util.setTotal( 1 );
            util.setData( jsonObject );
            util.setStep( 2 );
            util.setError_code( 1 );
            util.setMsg( "数据错误！" );
        }
        return util;

    }

    /**
     * 审批记录删除
     *
     * @param approval 审批编号
     * @return
     */
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    public RestfulUtil del(String approval) {
        XCtraveltravel tt = new XCtraveltravel();
        tt.setApproval( approval );
        RestfulUtil util = new RestfulUtil();
        int del = service.del( approval );
        if (0 != del) {
            util = new RestfulUtil();
            String myJsonObj = JSON.toJSONString( tt );
            JSONObject jsonObject = JSON.parseObject( myJsonObj );
            util.setTotal( 1 );
            util.setData( jsonObject );
            util.setStep( 1 );
            util.setError_code( 0 );
            util.setMsg( "记录删除成功" );
            tpeservice.del( approval );
            tcService.del( approval );
            tpservice.del( approval );
        } else {
            util = new RestfulUtil();
            String myJsonObj = JSON.toJSONString( tt );
            JSONObject jsonObject = JSON.parseObject( myJsonObj );
            util.setTotal( 1 );
            util.setData( jsonObject );
            util.setStep( 1 );
            util.setError_code( 0 );
            util.setMsg( "不存在或已删除数据" );
        }
        return util;
    }


    /**
     * 个人审批列表查询
     *
     * @param userid 个人id
     * @return
     */
    @RequestMapping(value = "/querytable", method = {RequestMethod.POST})
    public List<XCtraveltravel> querytable(@RequestBody Map<String, Object> userid) {
        String aa = userid.get( "userid" ).toString();
        RestfulUtil util = new RestfulUtil();
        List<XCtraveltravel> querytable = service.querytable( aa );
        return querytable;
    }

    /**
     * 审批详情查询
     *
     * @param approval 审批编号
     * @return
     */
    @RequestMapping(value = "/queryall", method = {RequestMethod.POST})
    public RestfulUtil queryall(@RequestBody Map<String, Object> approval) {
        String aa = approval.get( "approval" ).toString();
        RestfulUtil util = new RestfulUtil();
        XCtraveltravel querytable = service.queryall( aa );
        if (querytable != null) {
            util = new RestfulUtil();
            String myJsonObj = JSON.toJSONString( querytable );
            JSONObject jsonObject = JSON.parseObject( myJsonObj );
            util.setTotal( 1 );
            util.setData( jsonObject );
            util.setStep( 1 );
            util.setError_code( 0 );
        } else {
            util.setTotal( 0 );
            util.setData( null );
            util.setStep( 1 );
            util.setError_code( 1 );
        }
        return util;
    }
}
