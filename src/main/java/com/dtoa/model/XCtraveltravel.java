package com.dtoa.model;

import java.util.List;

public class XCtraveltravel {
    private String approval;

    private String applyTime;

    private String departure;

    private String arrived;

    private String starttime;

    private String endtime;

    private String duration;

    private String unit;

    private String unitid;

    private String reasons;

    private String vehicles;

    private String company;

    private String userid;


    private List<XCtravelproject> XCtravelproject;
    private List<XCtravelpersonnel> XCtravelpersonnel;
    private List<XCtravelcallbacks> XCtravelcallbacks;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<com.dtoa.model.XCtravelpersonnel> getXCtravelpersonnel() {
        return XCtravelpersonnel;
    }

    public void setXCtravelpersonnel(List<com.dtoa.model.XCtravelpersonnel> XCtravelpersonnel) {
        this.XCtravelpersonnel = XCtravelpersonnel;
    }

    public List<com.dtoa.model.XCtravelcallbacks> getXCtravelcallbacks() {
        return XCtravelcallbacks;
    }

    public void setXCtravelcallbacks(List<com.dtoa.model.XCtravelcallbacks> XCtravelcallbacks) {
        this.XCtravelcallbacks = XCtravelcallbacks;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public List<com.dtoa.model.XCtravelproject> getXCtravelproject() {
        return XCtravelproject;
    }

    public void setXCtravelproject(List<com.dtoa.model.XCtravelproject> XCtravelproject) {
        this.XCtravelproject = XCtravelproject;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval == null ? null : approval.trim();
    }

    public String getApplytime() {
        return applyTime;
    }

    public void setApplytime(String applytime) {
        this.applyTime = applytime == null ? null : applytime.trim();
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure == null ? null : departure.trim();
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived == null ? null : arrived.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid == null ? null : unitid.trim();
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons == null ? null : reasons.trim();
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles == null ? null : vehicles.trim();
    }
}
