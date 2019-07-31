package com.dtoa.service;

import com.dtoa.model.XCtravelproject;

import java.util.List;

public interface XCtravelprojectService {
    void insert(XCtravelproject tp);

    int del(String approval);

    XCtravelproject sel(String approval);
}
