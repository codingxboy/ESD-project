package com.yunhe.entity.domain.erp;

import java.util.Date;

public class Organization {
    private Long id;

    private String orgNo;

    private String orgAbr;

    private Long parentId;

    private String sort;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String deleteFlag;

    public Organization(Long id, String orgNo, String orgAbr, Long parentId, String sort, String remark, Date createTime, Date updateTime, String deleteFlag) {
        this.id = id;
        this.orgNo = orgNo;
        this.orgAbr = orgAbr;
        this.parentId = parentId;
        this.sort = sort;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public Organization() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    public String getOrgAbr() {
        return orgAbr;
    }

    public void setOrgAbr(String orgAbr) {
        this.orgAbr = orgAbr == null ? null : orgAbr.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
