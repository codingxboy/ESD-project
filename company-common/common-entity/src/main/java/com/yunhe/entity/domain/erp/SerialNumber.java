package com.yunhe.entity.domain.erp;

import java.util.Date;

public class SerialNumber {
    private Long id;

    private Long materialId;

    private Long depotId;

    private String serialNumber;

    private String isSell;

    private String remark;

    private String deleteFlag;

    private Date createTime;

    private Long creator;

    private Date updateTime;

    private Long updater;

    private String inBillNo;

    private String outBillNo;

    public SerialNumber(Long id, Long materialId, Long depotId, String serialNumber, String isSell, String remark, String deleteFlag, Date createTime, Long creator, Date updateTime, Long updater, String inBillNo, String outBillNo) {
        this.id = id;
        this.materialId = materialId;
        this.depotId = depotId;
        this.serialNumber = serialNumber;
        this.isSell = isSell;
        this.remark = remark;
        this.deleteFlag = deleteFlag;
        this.createTime = createTime;
        this.creator = creator;
        this.updateTime = updateTime;
        this.updater = updater;
        this.inBillNo = inBillNo;
        this.outBillNo = outBillNo;
    }

    public SerialNumber() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getIsSell() {
        return isSell;
    }

    public void setIsSell(String isSell) {
        this.isSell = isSell == null ? null : isSell.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public String getInBillNo() {
        return inBillNo;
    }

    public void setInBillNo(String inBillNo) {
        this.inBillNo = inBillNo == null ? null : inBillNo.trim();
    }

    public String getOutBillNo() {
        return outBillNo;
    }

    public void setOutBillNo(String outBillNo) {
        this.outBillNo = outBillNo == null ? null : outBillNo.trim();
    }
}
