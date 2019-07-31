package com.dtoa.model;

public class XCtravelproject {
    private String approval;

    private String projectname;

    private String prnumber;

    private String worktype;

    private String market;

    private String othersales;

    private String sellunit;

    private String othersalesid;

    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOthersalesid() {
        return othersalesid;
    }

    public void setOthersalesid(String othersalesid) {
        this.othersalesid = othersalesid;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval == null ? null : approval.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getPrnumber() {
        return prnumber;
    }

    public void setPrnumber(String prnumber) {
        this.prnumber = prnumber == null ? null : prnumber.trim();
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype == null ? null : worktype.trim();
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market == null ? null : market.trim();
    }

    public String getOthersales() {
        return othersales;
    }

    public void setOthersales(String othersales) {
        this.othersales = othersales == null ? null : othersales.trim();
    }

    public String getSellunit() {
        return sellunit;
    }

    public void setSellunit(String sellunit) {
        this.sellunit = sellunit == null ? null : sellunit.trim();
    }
}
