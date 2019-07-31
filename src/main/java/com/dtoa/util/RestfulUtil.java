package com.dtoa.util;


import com.alibaba.fastjson.JSONObject;

public class RestfulUtil {

    private int error_code;
    private String msg;
    private JSONObject data;
    private int total;
    private int step;

    public RestfulUtil() {
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }


/** restful 返回 */
}
