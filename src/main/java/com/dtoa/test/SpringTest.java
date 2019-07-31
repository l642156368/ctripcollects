/*
package com.dtoa.test;

import com.dtoa.ZhangwenApplication;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.types.Schema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

*/
/**
 * @ClassName SpringTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/6/18 0018 10:12
 * @Version 1.0
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZhangwenApplication.class)//这里的Application是springboot的启动类名
@WebAppConfiguration
public class SpringTest {
    @Test
    public void loadPrjs() {
        String cardNum = null;
        try {
            String endpoint = "http://xt.dhcc.com.cn:9080/xtwebservice/services/IModuleService";
            // 直接引用远程的wsdl文件,"?wsdl"前的链接
            String method = "loadPejs";
            String namespace = "http://www.w3.org/2001/XMLSchema";

            Service service = new Service();
            Call call = (Call) service.createCall();
            //设置服务器地址
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            //设置命名空间和调用方法
            call.setOperationName(new QName(namespace, method));// WSDL里面描述的接口名称
            call.setUseSOAPAction(true);


            //设置header，如果有security需求的话
//            SOAPHeaderElement soapHeaderElement = createHeader();
//            if(soapHeaderElement == null){
//                System.out.println("====Exception");
//                return;
//            }
//            call.addHeader(soapHeaderElement);

            //添加方法的参数，有几个添加几个
            call.addParameter("param1", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
            //call.addParameter("param2", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
            //设置返回类型

            */
/*返回类型可以不设置，如果是简单类型可以使用XMLType.XSD_STRING等简单类型，这里使用schema解析返回的报文。
            如果接收的类型和设置的类型不一致，会报以下异常：
            SimpleDeserializer encountered a child element, which is NOT expected, in something it was trying to deserialize.*//*

            call.setReturnType(XMLType.XSD_SCHEMA);// 设置返回类型

            String queryEmp = "刘克举";
            String query = "舆情大数";
           // Schema result = (Schema) call.invoke(new Object[]{queryEmp});
            Schema result = (Schema) call.invoke(new Object[]{query});
            System.out.println("result:" + result.toString());

            //解析返回结果
//            MessageElement[] data = result.get_any();
//            for(int i=0; i<data.length; i++){
//                SAXReader reader = new SAXReader();
//                Document doc = reader.read(new ByteArrayInputStream(data[i].toString().getBytes()));
//                System.out.println(doc.getStringValue());
//            }


            //输出SOAP请求报文
            System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
            //输出SOAP返回报文
            System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
            Map<String, Object> map = XMLUtil.xml2Map(call.getResponseMessage().getSOAPPartAsString());
            System.out.println("map:" + map);
            System.out.println("map.out:" + map.get("out"));
            Map<String, Object> map1 = JsonXMLUtils.json2map((String) map.get("out"));
        //    System.out.println("json->map:" + map1.get("status"));
            List<Map<String, Object>> detailBeans = (List<Map<String, Object>>) map1.get("detailBeans");
            System.out.println("detailBeans:" + detailBeans);
            //            for (Map<String, Object> detailBean : detailBeans) {
//                System.out.println("工号："+detailBean.get("fodemp"));
//            }
//            if (detailBeans.size() == 1) {
//                cardNum = detailBeans.get(0).get("fodemp").toString();
//            }
//            System.out.println("工号：" + cardNum);
            //return cardNum;
        } catch (Exception e) {
            e.printStackTrace();
            //return cardNum;
        }
    }


    @Test
    public void getEmp() {
        String cardNum = null;
        try {
            String endpoint = "http://xt.dhcc.com.cn:9080/xtwebservice/services/IModuleService";
            // 直接引用远程的wsdl文件,"?wsdl"前的链接
            String method = "getEmp";
            String namespace = "http://www.w3.org/2001/XMLSchema";

            Service service = new Service();
            Call call = (Call) service.createCall();
            //设置服务器地址
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            //设置命名空间和调用方法
            call.setOperationName(new QName(namespace, method));// WSDL里面描述的接口名称
            call.setUseSOAPAction(true);


            //设置header，如果有security需求的话
//            SOAPHeaderElement soapHeaderElement = createHeader();
//            if(soapHeaderElement == null){
//                System.out.println("====Exception");
//                return;
//            }
//            call.addHeader(soapHeaderElement);

            //添加方法的参数，有几个添加几个
            //call.addParameter("param1", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
            //call.addParameter("param2", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
            //设置返回类型

            */
/*返回类型可以不设置，如果是简单类型可以使用XMLType.XSD_STRING等简单类型，这里使用schema解析返回的报文。
            如果接收的类型和设置的类型不一致，会报以下异常：
            SimpleDeserializer encountered a child element, which is NOT expected, in something it was trying to deserialize.*//*

            call.setReturnType(XMLType.XSD_SCHEMA);// 设置返回类型

            //String phone = "";
            //String email = "";
            //Schema result = (Schema) call.invoke(new Object[]{phone, email});
            Schema result = (Schema) call.invoke(new Object[]{});
            System.out.println("result:" + result.toString());

            //解析返回结果
//            MessageElement[] data = result.get_any();
//            for(int i=0; i<data.length; i++){
//                SAXReader reader = new SAXReader();
//                Document doc = reader.read(new ByteArrayInputStream(data[i].toString().getBytes()));
//                System.out.println(doc.getStringValue());
//            }


            //输出SOAP请求报文
            System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
            //输出SOAP返回报文
            System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
            Map<String, Object> map = XMLUtil.xml2Map(call.getResponseMessage().getSOAPPartAsString());
            System.out.println("map:" + map);
            System.out.println("map.out:" + map.get("out"));
            Map<String, Object> map1 = JsonXMLUtils.json2map((String) map.get("out"));
            System.out.println("json->map:" + map1.get("status"));
            List<Map<String, Object>> detailBeans = (List<Map<String, Object>>) map1.get("detailBeans");
            System.out.println("detailBeans:" + detailBeans);
            //            for (Map<String, Object> detailBean : detailBeans) {
//                System.out.println("工号："+detailBean.get("fodemp"));
//            }
//            if (detailBeans.size() == 1) {
//                cardNum = detailBeans.get(0).get("fodemp").toString();
//            }
//            System.out.println("工号：" + cardNum);
            //return cardNum;
        } catch (Exception e) {
            e.printStackTrace();
            //return cardNum;
        }
    }

}
*/
