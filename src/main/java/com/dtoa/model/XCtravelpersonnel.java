package com.dtoa.model;

public class XCtravelpersonnel {
    private String approval;

    private String pedestrian;

    private String pedestrianid;

    private String trekking;

    private String trekkingid;

    private String approvers;

    private String approversid;

    private String renews;

    private String renewsid;

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval == null ? null : approval.trim();
    }

    public String getPedestrian() {
        return pedestrian;
    }

    public void setPedestrian(String pedestrian) {
        this.pedestrian = pedestrian == null ? null : pedestrian.trim();
    }

    public String getPedestrianid() {
        return pedestrianid;
    }

    public void setPedestrianid(String pedestrianid) {
        this.pedestrianid = pedestrianid == null ? null : pedestrianid.trim();
    }

    public String getTrekking() {
        return trekking;
    }

    public void setTrekking(String trekking) {
        this.trekking = trekking == null ? null : trekking.trim();
    }

    public String getTrekkingid() {
        return trekkingid;
    }

    public void setTrekkingid(String trekkingid) {
        this.trekkingid = trekkingid == null ? null : trekkingid.trim();
    }

    public String getApprovers() {
        return approvers;
    }

    public void setApprovers(String approvers) {
        this.approvers = approvers == null ? null : approvers.trim();
    }

    public String getApproversid() {
        return approversid;
    }

    public void setApproversid(String approversid) {
        this.approversid = approversid == null ? null : approversid.trim();
    }

    public String getRenews() {
        return renews;
    }

    public void setRenews(String renews) {
        this.renews = renews == null ? null : renews.trim();
    }

    public String getRenewsid() {
        return renewsid;
    }

    public void setRenewsid(String renewsid) {
        this.renewsid = renewsid == null ? null : renewsid.trim();
    }
}