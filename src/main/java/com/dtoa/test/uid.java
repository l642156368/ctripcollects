package com.dtoa.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class uid {

    private static CloseableHttpClient httpClient;


    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal( 100 );
        cm.setDefaultMaxPerRoute( 20 );
        cm.setDefaultMaxPerRoute( 50 );
        httpClient = HttpClients.custom().setConnectionManager( cm ).build();
    }

    public JSONArray getXtIdByUserIds(String params) {
        JSONObject object = JSON.parseObject( params );
        JSONArray ids = new JSONArray();
        for (String obj : object.keySet()) {
            String id = object.getString( obj );
            ids.add( id );
        }
        try {
            String result = post( "http://172.27.100.2:11003/address/user/useridToXtId", ids.toJSONString() );
            if (result != null) {
                JSONObject resultObj = JSON.parseObject( result );
                if (resultObj.getInteger( "error_code" ) == 0) {
                    ids = resultObj.getJSONArray( "data" );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ids;
    }

    public String post(String url, String jsonString) throws IOException {
        if (jsonString == null) {
            JSONObject object = new JSONObject();
            jsonString = object.toJSONString();
        }
        CloseableHttpResponse response = null;
        BufferedReader in = null;
        String result = "";
        try {
            HttpPost httpPost = new HttpPost( url );
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout( 30000 ).setConnectionRequestTimeout( 30000 ).setSocketTimeout( 30000 ).build();
            httpPost.setConfig( requestConfig );
            httpPost.setConfig( requestConfig );
            httpPost.addHeader( "Content-type", "application/json; charset=utf-8" );
            httpPost.setHeader( "Accept", "application/json" );
            httpPost.setEntity( new StringEntity( jsonString, Charset.forName( "UTF-8" ) ) );
            response = httpClient.execute( httpPost );
            in = new BufferedReader( new InputStreamReader( response.getEntity().getContent() ) );
            StringBuffer sb = new StringBuffer( "" );
            String line = "";
            String NL = System.getProperty( "line.separator" );
            while ((line = in.readLine()) != null) {
                sb.append( line + NL );
            }
            in.close();
            result = sb.toString();

        } catch (UnknownHostException e) {
            throw new UnknownHostException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
