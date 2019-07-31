package com.dtoa.Config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dtoa.test.Information;
import com.dtoa.test.XMLUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.types.Schema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "chexun")
@RestController
public class chaxun {

    //    findXZCmp  fodemp   获取行政单位
    @ApiOperation(value = "根据条件获取行政单位")
    @RequestMapping(value = "administrative", method = {RequestMethod.GET})
    @ResponseBody
    public List administrative(String parameters) {

        Information inf = new Information();
        String methods = "findXZCmp";
        projectname( parameters, methods );
        JSONArray detailBeans = (JSONArray) inf.projectname( parameters, methods );
        List<String> list = new ArrayList<>();

        for (int i = 0; i < detailBeans.size(); i++) {
            JSONObject object = detailBeans.getJSONObject( i );
            String fdeschs = object.getString( "FDESCHS" );
            String FODCMP = object.getString( "FODCMP" );
            System.out.println( fdeschs );
            list.add( fdeschs );
            System.out.println( FODCMP );
            list.add( FODCMP );
        }
        System.out.println( list );
        return list;
    }

    public Object projectname(String parameters, String method) {

        try {
            String endpoint = "http://xt.dhcc.com.cn:9080/xtwebservice/services/IModuleService";

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
            if (method == "findXZCmp") {
                String fodemp = parameters;
                Schema result = (Schema) call.invoke( new Object[]{fodemp} );
                //  System.out.println("result:" + result.toString());
                //  System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
                //输出SOAP返回报文
                //  System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
                Map<String, Object> map = XMLUtil.xml2Map( call.getResponseMessage().getSOAPPartAsString() );

                JSONObject json = JSON.parseObject( map.get( "out" ).toString() );
                System.out.println( json );
                JSONArray detailBeans = json.getJSONArray( "detailBeans" );

                List<String> list = new ArrayList<>();
                list.add( detailBeans.toString() );
                return detailBeans;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

}
