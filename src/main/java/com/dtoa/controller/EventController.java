package com.dtoa.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dtoa.aes.AesException;
import com.dtoa.aes.WXBizMsgCrypt;
import com.dtoa.model.XCtravelcallbacks;
import com.dtoa.model.token;
import com.dtoa.service.XCtravelcallbacksService;
import com.dtoa.test.XMLUtil;
import com.dtoa.util.RequestUtil;
import com.dtoa.util.RestUtil;
import com.dtoa.util.RestfulUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName ApplicationController
 * @Description
 * @Author Administrator
 * @Date 2019/1/3 0003 16:02
 * @Version 1.0
 */

@RestController
@CrossOrigin
@RequestMapping("/approval")
public class EventController {
    private final Logger logger = LoggerFactory.getLogger( this.getClass() );
    @Autowired
    private pushcontroller push;
    @Resource
    private token token;

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public void EntryMethod(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info( "初次校验URL地址开始。。" );
        // 微信加密签名
        String msg_signature = request.getParameter( "msg_signature" );
        // 时间戳
        String timestamp = request.getParameter( "timestamp" );
        // 随机数
        String nonce = request.getParameter( "nonce" );
        // 随机字符串
        String echostr = request.getParameter( "echostr" );
        //System.out.println("request=" + request.getRequestURL());
        PrintWriter out = response.getWriter();
        // 通过检验msg_signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        String result = null;
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt( token.getToken(), token.getEncodingAESKey(), token.getCorpId() );
            result = wxcpt.VerifyURL( msg_signature, timestamp, nonce, echostr );
            String xmlStr = wxcpt.DecryptMsg( msg_signature, timestamp, nonce, echostr );
        } catch (AesException e) {
            e.printStackTrace();
        }
        if (result == null) {
            result = token.getToken();
        }
        out.print( result );
        out.close();
        logger.info( "初次校验URL地址结束" );
    }

    @Resource
    private XCtravelcallbacksService service;

    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    public void EntryMethod2(HttpServletRequest request, HttpServletResponse response, @RequestBody String postData) throws Exception {
        logger.info( "从企业微信接收到事件" );
        // 微信加密签名
        String msg_signature = request.getParameter( "msg_signature" );
        // 时间戳
        String timestamp = request.getParameter( "timestamp" );
        // 随机数
        String nonce = request.getParameter( "nonce" );
        // 随机字符串
        String echostr = request.getParameter( "echostr" );
        //System.out.println("request=" + request.getRequestURL());
        PrintWriter out = response.getWriter();
        // 通过检验msg_signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        String result = null;
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt( token.getToken(), token.getEncodingAESKey(), token.getCorpId() );
            String xmlStr = wxcpt.DecryptMsg( msg_signature, timestamp, nonce, postData );
            Map<String, Object> xmlMap = XMLUtil.xml2Map( xmlStr );
            //System.out.println("xmlmap=" + xmlMap);
            logger.info( "企业微信事件解析内容：" + xmlMap );
            XCtravelcallbacks xc = new XCtravelcallbacks();
            if (xmlMap.get( "Event" ) != null && "open_approval_change".equals( xmlMap.get( "Event" ) )) {
                if (xmlMap.get( "ThirdNo" ) != null) {
                    String ThirdNo = xmlMap.get( "ThirdNo" ).toString();
                    System.out.println( ThirdNo );
                    xc.setThirdno( ThirdNo );
                }
                if (xmlMap.get( "CreateTime" ) != null) {
                    String CreateTime = xmlMap.get( "CreateTime" ).toString();
                    System.out.println( CreateTime );
                    xc.setCreatetime( CreateTime );
                }
                if (xmlMap.get( "Event" ) != null) {
                    String Event = xmlMap.get( "Event" ).toString();
                    System.out.println( Event );
                    xc.setEvent( Event );
                }
                if (xmlMap.get( "OpenSpStatus" ) != null) {
                    String OpenSpStatus = xmlMap.get( "OpenSpStatus" ).toString();
                    System.out.println( OpenSpStatus );
                    xc.setOpenspstatus( OpenSpStatus );
                }
                if (xmlMap.get( "ApplyTime" ) != null) {
                    String ApplyTime = xmlMap.get( "ApplyTime" ).toString();
                    System.out.println( ApplyTime );
                    xc.setApplytime( ApplyTime );
                }
                if (xmlMap.get( "ApplyUserName" ) != null) {
                    String ApplyUserName = xmlMap.get( "ApplyUserName" ).toString();
                    System.out.println( ApplyUserName );
                    xc.setApplyusername( ApplyUserName );
                }
                if (xmlMap.get( "ApplyUserId" ) != null) {
                    String ApplyUserId = xmlMap.get( "ApplyUserId" ).toString();
                    System.out.println( ApplyUserId );
                    xc.setApplyuserid( ApplyUserId );
                }
                if (xmlMap.get( "ApplyUserParty" ) != null) {
                    String ApplyUserParty = xmlMap.get( "ApplyUserParty" ).toString();
                    System.out.println( ApplyUserParty );
                    xc.setApplyuserparty( ApplyUserParty );
                }
                if (xmlMap.get( "ApplyUserImage" ) != null) {
                    String ApplyUserImage = xmlMap.get( "ApplyUserImage" ).toString();
                    System.out.println( ApplyUserImage );
                    xc.setApplyuserimage( ApplyUserImage );
                }
                if (xmlMap.get( "NodeStatus" ) != null) {
                    String NodeStatus = xmlMap.get( "NodeStatus" ).toString();
                    xc.setNodestatus( NodeStatus );
                }
                if (xmlMap.get( "ItemName" ) != null) {
                    String ItemName = xmlMap.get( "ItemName" ).toString();
                    System.out.println( ItemName );
                    xc.setItemname( ItemName );

                }
                if (xmlMap.get( "ItemUserid" ) != null) {
                    String ItemUserid = xmlMap.get( "ItemUserid" ).toString();
                    System.out.println( ItemUserid );
                    xc.setItemuserid( ItemUserid );

                }
                if (xmlMap.get( "ItemStatus" ) != null) {
                    String ItemStatus = xmlMap.get( "ItemStatus" ).toString();

                    xc.setItemstatus( ItemStatus );

                }
                if (xmlMap.get( "ItemOpTime" ) != null) {
                    String ItemOpTime = xmlMap.get( "ItemOpTime" ).toString();

                    xc.setItemoptime( ItemOpTime );

                }
                if (xmlMap.get( "ItemImage" ) != null) {
                    String ItemImage = xmlMap.get( "ItemImage" ).toString();
                    System.out.println( ItemImage );
                    xc.setItemimage( ItemImage );

                }
                if (xmlMap.get( "NotifyNodes" ) != null) {
                    String NotifyNodes = xmlMap.get( "NotifyNodes" ).toString();
                    System.out.println( NotifyNodes );
                    xc.setNotifynodes( NotifyNodes );

                }
                if (xmlMap.get( "copyName" ) != null) {
                    String copyName = xmlMap.get( "copyName" ).toString();
                    System.out.println( copyName );
                    xc.setCopyname( copyName );

                }
                if (xmlMap.get( "copyUserid" ) != null) {
                    String copyUserid = xmlMap.get( "copyUserid" ).toString();
                    System.out.println( copyUserid );
                    xc.setCopyuserid( copyUserid );

                }
                if (xmlMap.get( "copyImage" ) != null) {
                    String copyImage = xmlMap.get( "copyImage" ).toString();
                    System.out.println( copyImage );
                    xc.setCopyimage( copyImage );

                }
                if (xmlMap.get( "ItemParty" ) != null) {
                    String ItemParty = xmlMap.get( "ItemParty" ).toString();
                    System.out.println( ItemParty );
                    xc.setItemparty( ItemParty );
                }
                if (xmlMap.get( "approverstep" ) != null) {
                    String approverstep = xmlMap.get( "approverstep" ).toString();
                    System.out.println( approverstep );
                    xc.setApproverstep( approverstep );

                }

                if (xmlMap.get( "ThirdNo" ) != null) {
                    String ThirdNo = xmlMap.get( "ThirdNo" ).toString();
                    System.out.println( ThirdNo );
                    int app = service.query( ThirdNo );
                    if (0 != app) {
                        service.updete( xc );
                    } else {
                        service.insert( xc );
                    }
                }
            }

            String OpenSpStatus = xmlMap.get( "OpenSpStatus" ).toString();
            String NodeStatus = xmlMap.get( "NodeStatus" ).toString();
            if (OpenSpStatus.equals( "2" )) {
                if (xmlMap.get( "ThirdNo" ) != null) {
                    String approval = xmlMap.get( "ThirdNo" ).toString();
                    System.out.println( "ThirdNo:" + approval );
                    push.push( approval );
                }

            }


            result = wxcpt.EncryptMsg( "接受成功", timestamp, nonce );
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            result = token.getToken();
        }
        out.print( result );
        out.close();
        logger.info( "企业审批消息处理完成！" );
    }
}


