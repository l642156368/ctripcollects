package com.dtoa.test; /**
 * @ClassName WebserviceUtilTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/26 0026 15:02
 * @Version 1.0
 */


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.types.Schema;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPFactory;
import java.util.List;
import java.util.Map;


public class WebserviceUtilTest {
    public static void main(String[] args) {
        try {
            String endpoint = "http://xt.dhcc.com.cn:9080/xtwebservice/services/IModuleService";
            // 直接引用远程的wsdl文件,"?wsdl"前的链接
            String method = "loadPrjs";
            String namespace = "http://www.w3.org/2001/XMLSchema";

            Service service = new Service();
            Call call = (Call) service.createCall();
            //设置服务器地址
            call.setTargetEndpointAddress( new java.net.URL( endpoint ) );
            //设置命名空间和调用方法
            call.setOperationName( new QName( namespace, method ) );// WSDL里面描述的接口名称
            call.setUseSOAPAction( true );


            //设置header，如果有security需求的话
//            SOAPHeaderElement soapHeaderElement = createHeader();
//            if(soapHeaderElement == null){
//                System.out.println("====Exception");
//                return;
//            }
//            call.addHeader(soapHeaderElement);

            //添加方法的参数，有几个添加几个
            call.addParameter( "param1", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN );// 接口的参数
            // call.addParameter("param2", XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
            //设置返回类型

            /*返回类型可以不设置，如果是简单类型可以使用XMLType.XSD_STRING等简单类型，这里使用schema解析返回的报文。
            如果接收的类型和设置的类型不一致，会报以下异常：
            SimpleDeserializer encountered a child element, which is NOT expected, in something it was trying to deserialize.*/
            call.setReturnType( XMLType.XSD_SCHEMA );// 设置返回类型

            String query = "舆情大数";
            // String email = "";
            Schema result = (Schema) call.invoke( new Object[]{query} );
            //  System.out.println("result:" + result.toString());


            //解析返回结果
//            MessageElement[] data = result.get_any();
//            for(int i=0; i<data.length; i++){
//                SAXReader reader = new SAXReader();
//                Document doc = reader.read(new ByteArrayInputStream(data[i].toString().getBytes()));
//                System.out.println(doc.getStringValue());
//            }


            //输出SOAP请求报文
            //  System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
            //输出SOAP返回报文
            //  System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
            Map<String, Object> map = XMLUtil.xml2Map( call.getResponseMessage().getSOAPPartAsString() );
            //  System.out.println("map:" + map);
            //  System.out.println("map.out:" + map.get("out"));
            Map<String, Object> map1 = JsonXMLUtils.json2map( (String) map.get( "out" ) );

            //  System.out.println("json->map:" + map1.get("status"));
            List<Map<String, Object>> detailBeans = (List<Map<String, Object>>) map1.get( "detailBeans" );
            for (Map<String, Object> detailBean : detailBeans) {
                //  System.out.println("工号：" + detailBean.get("fodemp"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
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
