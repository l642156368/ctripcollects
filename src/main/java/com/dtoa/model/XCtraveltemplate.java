package com.dtoa.model;

public class XCtraveltemplate {
    private String tempid;

    private String tempname;

    private String templateid;

    private String department;

    private String tempdescribe;

    public String getTempid() {
        return tempid;
    }

    public void setTempid(String tempid) {
        this.tempid = tempid == null ? null : tempid.trim();
    }

    public String getTempname() {
        return tempname;
    }

    public void setTempname(String tempname) {
        this.tempname = tempname == null ? null : tempname.trim();
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid == null ? null : templateid.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getTempdescribe() {
        return tempdescribe;
    }

    public void setTempdescribe(String tempdescribe) {
        this.tempdescribe = tempdescribe == null ? null : tempdescribe.trim();
    }
}