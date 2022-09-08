package com.yunhe.entity.domain.erp;

import java.util.Date;

public class Log {
    private Long id;

    private Long userId;

    private String operation;

    private String clientIp;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    private String content;

    public Log(Long id, Long userId, String operation, String clientIp, Date createTime, Date updateTime,Byte status, String content) {
        this.id = id;
        this.userId = userId;
        this.operation = operation;
        this.clientIp = clientIp;
        this.createTime = createTime;
        this.updateTime=updateTime;
        this.status = status;
        this.content = content;
    }

    public Log() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
