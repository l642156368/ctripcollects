package com.dtoa.service;

import com.dtoa.model.XCtravelcallbacks;

import java.util.Map;

public interface XCtravelcallbacksService {
    int del(String approval);


    void insert(XCtravelcallbacks xc);

    XCtravelcallbacks sel(String ThirdNo);

    int query(String thirdNo);

    void updete(XCtravelcallbacks xc);
}
