package com.fp.common.core.model;

import lombok.Data;

import java.util.Date;

public class BaseVO {

    protected Date createTime;

    protected Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
