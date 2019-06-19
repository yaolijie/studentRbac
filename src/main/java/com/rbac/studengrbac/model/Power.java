package com.rbac.studengrbac.model;

import java.util.Date;

public class Power {

    private String id;
    private String type;
    private String fullName;
    private String name;
    private String code;
    private String intercepUrl;
    private String paretId;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntercepUrl() {
        return intercepUrl;
    }

    public void setIntercepUrl(String intercepUrl) {
        this.intercepUrl = intercepUrl;
    }

    public String getParetId() {
        return paretId;
    }

    public void setParetId(String paretId) {
        this.paretId = paretId;
    }
}
