package com.dtoa.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * @ClassName JsonXMLUtils
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/3 0003 11:37
 * @Version 1.0
 */
public class JsonXMLUtils {

    public static String obj2json(Object obj) throws Exception {
        return JSON.toJSONString( obj );
    }

    public static <T> T json2obj(String jsonStr, Class<T> clazz) throws Exception {
        return JSON.parseObject( jsonStr, clazz );
    }

    public static <T> Map<String, Object> json2map(String jsonStr) throws Exception {
        return JSON.parseObject( jsonStr, Map.class );
    }

    public static <T> T map2obj(Map<?, ?> map, Class<T> clazz) throws Exception {
        return JSON.parseObject( JSON.toJSONString( map ), clazz );
    }

    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString( ts );
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {

        List<T> ts = (List<T>) JSONArray.parseArray( jsonString, clazz );
        return ts;
    }
}
