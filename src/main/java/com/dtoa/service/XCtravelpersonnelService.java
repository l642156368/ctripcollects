package com.dtoa.service;

import com.dtoa.model.XCtravelpersonnel;

import java.util.List;

public interface XCtravelpersonnelService {
    void insert(XCtravelpersonnel tep);

    int del(String approval);

    XCtravelpersonnel sel(String approval);
}
