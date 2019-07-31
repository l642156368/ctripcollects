package com.dtoa.service;

import com.dtoa.model.test;

import java.util.List;

public interface testservice {
    List<test> qyery();

    int del(String a);

    int insert(test test);

    int update(test test);
}
