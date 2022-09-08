package com.yunhe.entity.domain.erp;

import java.math.BigDecimal;

public class AccountItem {
    private Long id;

    private Long headerId;

    private Long accountId;

    private Long inOutItemId;

    private Long billId;

    private BigDecimal needDebt;

    private BigDecimal finishDebt;

    private BigDecimal eachAmount;

    private String remark;

    private String deleteFlag;

    public AccountItem(Long id, Long headerId, Long accountId, Long inOutItemId, Long billId, BigDecimal needDebt, BigDecimal finishDebt, BigDecimal eachAmount, String remark, String deleteFlag) {
        this.id = id;
        this.headerId = headerId;
        this.accountId = accountId;
        this.inOutItemId = inOutItemId;
        this.billId = billId;
        this.needDebt = needDebt;
        this.finishDebt = finishDebt;
        this.eachAmount = eachAmount;
        this.remark = remark;
        this.deleteFlag = deleteFlag;
    }

    public AccountItem() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getInOutItemId() {
        return inOutItemId;
    }

    public void setInOutItemId(Long inOutItemId) {
        this.inOutItemId = inOutItemId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public BigDecimal getNeedDebt() {
        return needDebt;
    }

    public void setNeedDebt(BigDecimal needDebt) {
        this.needDebt = needDebt;
    }

    public BigDecimal getFinishDebt() {
        return finishDebt;
    }

    public void setFinishDebt(BigDecimal finishDebt) {
        this.finishDebt = finishDebt;
    }

    public BigDecimal getEachAmount() {
        return eachAmount;
    }

    public void setEachAmount(BigDecimal eachAmount) {
        this.eachAmount = eachAmount;
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
}
