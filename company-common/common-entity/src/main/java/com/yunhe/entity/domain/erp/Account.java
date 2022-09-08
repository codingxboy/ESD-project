package com.yunhe.entity.domain.erp;

import java.math.BigDecimal;

public class Account {
    private Long id;

    private String name;

    private String serialNo;

    private BigDecimal initialAmount;

    private BigDecimal currentAmount;

    private String remark;

    private Boolean isDefault;

    private String deleteFlag;

    public Account(Long id, String name, String serialNo, BigDecimal initialAmount, BigDecimal currentAmount, String remark, Boolean isDefault, String deleteFlag) {
        this.id = id;
        this.name = name;
        this.serialNo = serialNo;
        this.initialAmount = initialAmount;
        this.currentAmount = currentAmount;
        this.remark = remark;
        this.isDefault = isDefault;
        this.deleteFlag = deleteFlag;
    }

    public Account() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
