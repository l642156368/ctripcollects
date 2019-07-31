package com.dtoa.controller;


import com.dtoa.model.XCtravelcallbacks;
import com.dtoa.model.XCtravelpersonnel;
import com.dtoa.model.XCtravelproject;
import com.dtoa.model.XCtraveltravel;
import com.dtoa.service.XCtravelcallbacksService;
import com.dtoa.service.XCtravelpersonnelService;
import com.dtoa.service.XCtravelprojectService;
import com.dtoa.service.XCtraveltravelService;
import com.dtoa.test.uid;
import com.dtoa.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "push")
public class pushcontroller {

    @Resource
    private XCtraveltravelService ttservice;
    @Autowired
    private XCtravelprojectService tpservice;
    @Autowired
    private XCtravelpersonnelService tpeservice;

    @Autowired
    private XCtravelcallbacksService tcservice;

    /**
     * 信息推送给携程
     *
     * @param approval 订单编号
     * @return
     */
    @RequestMapping(value = "push")
    public String push(String approval) {
        System.out.println( "获取数据推送携程" );
        String bb = "";
        try {
            if (approval != "") {
                XCtraveltravel tt = ttservice.sel( approval );
                XCtravelproject tp = tpservice.sel( approval );
                XCtravelpersonnel tpe = tpeservice.sel( approval );
                XCtraveltravel tt1 = new XCtraveltravel();
                String approva = tt.getApproval();
                String departure = tt.getDeparture();
                String arrived = tt.getArrived();
                long applyTime = new Date().getTime();
                String starttime = tt.getStarttime();
                String endtime = tt.getEndtime();
                String reasons = tt.getReasons();

                String tonxing = "";
                String trekking = tpe.getTrekking();
                int aa = trekking.indexOf( "," );
                if (aa != -1) {
                   String  aaa = trekking.replace( ",", " \",\"" ).replace( "无","" );
                    tonxing = "\""+aaa+"\"";
                } else {
                    tonxing = trekking.replace( "无","" );
                }


                String projectname = tp.getProjectname();
                String worktype = tp.getWorktype();
                String pedestrian = tpe.getPedestrian();
                String pedestrianid = tpe.getPedestrianid();
                String staff = "";
                String othersales = tp.getOthersales();
                String market = tp.getMarket();
                String userid = tt.getUserid();
                if (market == null || market == "") {
                    staff = othersales;
                } else {
                    staff = market;
                }

                String company = tt.getCompany();
                bb = "{\"data\":[{\n" +
                        "    \"createTime\": " + applyTime + ",\n" +
                        "    \"id\": \"" + approva + "\",\n" +
                        "    \"proInstanceState\": \"已通过\",\n" +
                        "    \"travelInfos\": [{\n" +
                        "      \"id\": \"departCity\",\n" +
                        "        \"name\": \"始发地\",\n" +
                        "        \"value\": \"" + departure + "\"\n" +
                        "    }, {\n" +
                        "        \"id\": \"address\",\n" +
                        "        \"name\": \"目的地\",\n" +
                        "        \"value\": \"" + arrived + "\"\n" +
                        "    },{\n" +
                        "        \"id\": \"date\",\n" +
                        "        \"name\": \"时间\",\n" +
                        "        \"value\": \"[\\\"" + starttime + "\\\",\\\"" + endtime + "\\\"]\"\n" +
                        "    },{\n" +
                        "    \t\"id\":\"partner\",\n" +
                        "    \t\"name\":\"同行人\",\n" +
                        "    \t\"value\":[" + tonxing + "]\n" +
                        "    },{\n" +
                        "        \"id\": \"reason\",\n" +
                        "        \"name\": \"出差事由\",\n" +
                        "        \"value\": \"" + reasons + "\"\n" +
                        "    }, {\n" +
                        "        \"id\": \"project_name\",\n" +
                        "        \"name\": \"项目名称\",\n" +
                        "        \"value\": \"" + projectname + "\"\n" +
                        "    }, {\n" +
                        "        \"id\": \"company\",\n" +
                        "        \"name\": \"记账单位\",\n" +
                        "        \"value\": \"" + company + "\"\n" +
                        "    }, {\n" +
                        "        \"id\": \"project_type\",\n" +
                        "        \"name\": \"项目类型\"\n" +
                        "    }, {\n" +
                        "        \"id\": \"manager\",\n" +
                        "        \"name\": \"项目负责人\"\n" +
                        "    }],\n" +
                        "    \"userId\": \"" + userid + "\",\n" +
                        "    \"userName\": \"" + pedestrian + "\",\n" +
                        "    \"Status\":1,\n" +
                        "    \"Ticket\":\"5c4145186c9c4265e411f11f\"\n" +
                        "}]\n" +
                        "}";
            }
            uid uid = new uid();
            System.out.println( bb );
            String chengg = uid.post( "http://118.24.137.48:11017/oaController/getOAwebSimpleCard", bb );
            return chengg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功";
    }
}
