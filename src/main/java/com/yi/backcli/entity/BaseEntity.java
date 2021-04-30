package com.yi.backcli.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 5154957576870025858L;

    private Long id;

    private Date createdTime;

    private Date modifiedTime;

    private Boolean deprecated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public BaseEntity() {
    }

    public BaseEntity(Long id, Date createdTime, Date modifiedTime, Boolean deprecated) {
        this.id = id;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.deprecated = deprecated;
    }
}
