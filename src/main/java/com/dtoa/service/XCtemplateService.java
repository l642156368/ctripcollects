package com.dtoa.service;

import com.dtoa.model.XCtraveltemplate;

import java.util.List;

public interface XCtemplateService {
    List<XCtraveltemplate> querytemp();

    XCtraveltemplate queryall(String tempid);

    XCtraveltemplate query(String company);

    int insert(XCtraveltemplate tt);
}
