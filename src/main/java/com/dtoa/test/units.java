package com.dtoa.test;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.types.Schema;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPFactory;
import java.util.Map;

public class units {
    public String units(@PathVariable String parameters) {
        try {
            String endpoint = "http://xt.dhcc.com.cn:9080/xtwebservice/services/IModuleService";
            // 直接引用远程的wsdl文件,"?wsdl"前的链接
            //    findXZCmp  fodemp   获取行政单位
            //    syncEmp    queryEmp  获取人员信息
            //    loadPejs   query     获取项目信息
            String method = "syncEmp";
            String namespace = "http://www.w3.org/2001/XMLSchema";
            Service service = new Service();
            Call call = (Call) service.createCall();
            //设置服务器地址
            call.setTargetEndpointAddress( new java.net.URL( endpoint ) );
            //设置命名空间和调用方法
            call.setOperationName( new QName( namespace, method ) );// WSDL里面描述的接口名称
            call.setUseSOAPAction( true );
            //添加方法的参数，有几个添加几个
            call.addParameter( "param1", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN );// 接口的参数
            // call.addParameter("param2", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
            //设置返回类型
            /*返回类型可以不设置，如果是简单类型可以使用XMLType.XSD_STRING等简单类型，这里使用schema解析返回的报文。
            如果接收的类型和设置的类型不一致，会报以下异常：
            SimpleDeserializer encountered a child element, which is NOT expected, in something it was trying to deserialize.*/
            call.setReturnType( XMLType.XSD_SCHEMA );// 设置返回类型
            //    findXZCmp  fodemp   获取行政单位
            //    syncEmp    queryEmp  获取人员信息
            //    loadPejs   query     获取项目信息
            String query = parameters;
            Schema result = (Schema) call.invoke( new Object[]{query} );
            //  System.out.println("result:" + result.toString());
            //输出SOAP请求报文
            //  System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
            //输出SOAP返回报文
            // System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
            Map<String, Object> map = XMLUtil.xml2Map( call.getResponseMessage().getSOAPPartAsString() );
            //   System.out.println("开始获取行政单位信息");
            // System.out.println("map:" + map);
            //System.out.println("map.out:" + map.get("out"));
          /*  Map<String, Object> map1 = JsonXMLUtils.json2map((String) map.get("out"));
            System.out.println("json->map:" + map1.get("status"));*/
            System.out.println( map );
            String aa = map.get( "fodemp" ).toString();
            if (aa == null) {
                return "2";
            } else {
                return "1";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    /*构造Header*/
    public static SOAPHeaderElement createHeader() {
        String AUTH_PREFIX = "wsse";
        String AUTH_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
        String TYPE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText";

        String userName = "admin";
        String passwd = "admin";


        //SOAPHeaderElement soapHeaderElement =new SOAPHeaderElement();


        try {
            SOAPFactory soapFactory = SOAPFactory.newInstance();
            SOAPElement wsSecHeaderElm = soapFactory.createElement( "Security", AUTH_PREFIX, AUTH_NS );
            SOAPElement userNameTokenElm = soapFactory.createElement( "UsernameToken", AUTH_PREFIX, AUTH_NS );
            SOAPElement userNameElm = soapFactory.createElement( "Username", AUTH_PREFIX, AUTH_NS );
            SOAPElement passwdElm = soapFactory.createElement( "Password", AUTH_PREFIX, AUTH_NS );
            passwdElm.setAttribute( "Type", TYPE );

            userNameElm.addTextNode( userName );
            passwdElm.addTextNode( passwd );

            userNameTokenElm.addChildElement( userNameElm );
            userNameTokenElm.addChildElement( passwdElm );
            wsSecHeaderElm.addChildElement( userNameTokenElm );

            SOAPHeaderElement soapHeaderElement = new SOAPHeaderElement( wsSecHeaderElm );
            soapHeaderElement.setMustUnderstand( true );

            return soapHeaderElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
