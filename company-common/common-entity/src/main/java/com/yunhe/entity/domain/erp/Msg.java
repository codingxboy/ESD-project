package com.yunhe.entity.domain.erp;

import java.util.Date;

public class Msg {
    private Long id;

    private String msgTitle;

    private String msgContent;

    private Date createTime;

    private String type;

    private String status;

    private String deleteFlag;

    public Msg(Long id, String msgTitle, String msgContent, Date createTime, String type, String status, String deleteFlag) {
        this.id = id;
        this.msgTitle = msgTitle;
        this.msgContent = msgContent;
        this.createTime = createTime;
        this.type = type;
        this.status = status;
        this.deleteFlag = deleteFlag;
    }

    public Msg() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle == null ? null : msgTitle.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
