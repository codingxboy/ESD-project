package com.yunhe.entity.domain.erp;
import com.yunhe.common.core.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 单据主表
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/2 11:18
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DepotHead extends BaseEntity {

    private static final long serialVersionUID = 4746168335118710340L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 类型(出库/入库)
     */
    private String type;
    /**
     * 出入库分类
     */
    private String subType;
    /**
     * 初始票据号
     */
    private String defaultNumber;
    /**
     * 票据号
     */
    private String number;
    /**
     * 出入库时间
     */
    private Date operTime;
    /**
     * 供应商Id
     */
    private Long organId;
    /**
     * 操作员id
     */
    private Long creatorId;
    /**
     * 账户Id
     */
    private Long accountId;
    /**
     * 变动金额(收款/付款)
     */
    private BigDecimal changeAmount;
    /**
     * 找零金额
     */
    private BigDecimal backAmount;
    /**
     * 合计金额
     */
    private BigDecimal totalPrice;
    /**
     * 付款类型(现金、记账等)
     */
    private String payType;
    /**
     * 单据类型
     */
    private String billType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 附件名称
     */
    private String fileName;
    /**
     * 业务员（可以多个）
     */
    private String salesMan;
    /**
     * 多账户ID列表
     */
    private String accountIdList;
    /**
     * 多账户金额列表
     */
    private String accountMoneyList;
    /**
     * 优惠率
     */
    private BigDecimal discount;
    /**
     * 优惠金额
     */
    private BigDecimal discountMoney;
    /**
     * 优惠后金额
     */
    private BigDecimal discountLastMoney;
    /**
     * 销售或采购费用合计
     */
    private BigDecimal otherMoney;
    /**
     * 订金
     */
    private BigDecimal deposit;
    /**
     * '状态，0未审核、1已审核、2完成采购|销售、3部分采购|销售'
     */
    private String status;
    /**
     * '采购状态，0未采购、2完成采购、3部分采购'
     */
    private String purchaseStatus;
    /**
     * 关联订单号
     */
    private String linkNumber;
    /**
     * 删除标记，0未删除，1删除，默认0
     */
    private String deleteFlag;

    public DepotHead(Long id, String type, String subType, String defaultNumber, String number, Date operTime, Long organId, Long creatorId, Long accountId, BigDecimal changeAmount, BigDecimal backAmount, BigDecimal totalPrice, String payType, String billType, String remark, String fileName, String salesMan, String accountIdList, String accountMoneyList, BigDecimal discount, BigDecimal discountMoney, BigDecimal discountLastMoney, BigDecimal otherMoney, BigDecimal deposit, String status, String purchaseStatus, String linkNumber, String deleteFlag) {
        this.id = id;
        this.type = type;
        this.subType = subType;
        this.defaultNumber = defaultNumber;
        this.number = number;
        this.operTime = operTime;
        this.organId = organId;
        this.creatorId = creatorId;
        this.accountId = accountId;
        this.changeAmount = changeAmount;
        this.backAmount = backAmount;
        this.totalPrice = totalPrice;
        this.payType = payType;
        this.billType = billType;
        this.remark = remark;
        this.fileName = fileName;
        this.salesMan = salesMan;
        this.accountIdList = accountIdList;
        this.accountMoneyList = accountMoneyList;
        this.discount = discount;
        this.discountMoney = discountMoney;
        this.discountLastMoney = discountLastMoney;
        this.otherMoney = otherMoney;
        this.deposit = deposit;
        this.status = status;
        this.purchaseStatus = purchaseStatus;
        this.linkNumber = linkNumber;
        this.deleteFlag = deleteFlag;
    }

    public DepotHead() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    public String getDefaultNumber() {
        return defaultNumber;
    }

    public void setDefaultNumber(String defaultNumber) {
        this.defaultNumber = defaultNumber == null ? null : defaultNumber.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public Long getOrganId() {
        return organId;
    }

    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreator(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getBackAmount() {
        return backAmount;
    }

    public void setBackAmount(BigDecimal backAmount) {
        this.backAmount = backAmount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan == null ? null : salesMan.trim();
    }

    public String getAccountIdList() {
        return accountIdList;
    }

    public void setAccountIdList(String accountIdList) {
        this.accountIdList = accountIdList == null ? null : accountIdList.trim();
    }

    public String getAccountMoneyList() {
        return accountMoneyList;
    }

    public void setAccountMoneyList(String accountMoneyList) {
        this.accountMoneyList = accountMoneyList == null ? null : accountMoneyList.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getDiscountLastMoney() {
        return discountLastMoney;
    }

    public void setDiscountLastMoney(BigDecimal discountLastMoney) {
        this.discountLastMoney = discountLastMoney;
    }

    public BigDecimal getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(BigDecimal otherMoney) {
        this.otherMoney = otherMoney;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus == null ? null : purchaseStatus.trim();
    }

    public String getLinkNumber() {
        return linkNumber;
    }

    public void setLinkNumber(String linkNumber) {
        this.linkNumber = linkNumber == null ? null : linkNumber.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    @Override
    public String toString() {
        return "DepotHead{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", defaultNumber='" + defaultNumber + '\'' +
                ", number='" + number + '\'' +
                ", operTime=" + operTime +
                ", organId=" + organId +
                ", creatorId=" + creatorId +
                ", accountId=" + accountId +
                ", changeAmount=" + changeAmount +
                ", backAmount=" + backAmount +
                ", totalPrice=" + totalPrice +
                ", payType='" + payType + '\'' +
                ", billType='" + billType + '\'' +
                ", remark='" + remark + '\'' +
                ", fileName='" + fileName + '\'' +
                ", salesMan='" + salesMan + '\'' +
                ", accountIdList='" + accountIdList + '\'' +
                ", accountMoneyList='" + accountMoneyList + '\'' +
                ", discount=" + discount +
                ", discountMoney=" + discountMoney +
                ", discountLastMoney=" + discountLastMoney +
                ", otherMoney=" + otherMoney +
                ", deposit=" + deposit +
                ", status='" + status + '\'' +
                ", purchaseStatus='" + purchaseStatus + '\'' +
                ", linkNumber='" + linkNumber + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                '}';
    }
}
