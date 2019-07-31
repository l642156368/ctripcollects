package com.dtoa.service;

import com.alibaba.fastjson.JSONObject;
import com.dtoa.model.XCtraveltravel;

import java.util.List;
import java.util.Map;

public interface XCtraveltravelService {
    List<XCtraveltravel> query(String approval, String OpenSpStatus, String NodeStatus);

    void insert(XCtraveltravel tt);

    int del(String approval);

    Object querys(String approval);

    void inserts(XCtraveltravel aa);

    XCtraveltravel sel(String approval);

    List<XCtraveltravel> querytable(String userid);

    XCtraveltravel queryall(String approval);
}
