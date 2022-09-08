package com.yunhe.entity.domain.erp;

import com.yunhe.common.core.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 单据子表
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/18 16:44
 */
public class DepotItem extends BaseEntity {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 主表id
     */
    private Long headerId;

    /**
     * 商品id
     */
    private Long materialId;
    /**
     * 商品扩展id
     */
    private Long materialExtendId;
    /**
     * 商品计量单位
     */
    private String materialUnit;
    /**
     * 商品sku
     */
    private String sku;
    /**
     * 商品数量
     */
    private BigDecimal operNumber;
    /**
     * 商品基础数量单位，如kg、瓶
     */
    private BigDecimal basicNumber;
    /**
     * 商品单价
     */
    private BigDecimal unitPrice;
    /**
     * 商品含税单价
     */
    private BigDecimal taxUnitPrice;
    /**
     * 商品金额
     */
    private BigDecimal allPrice;
    /**
     * 商品描述
     */
    private String remark;
    /**
     * 仓库ID
     */
    private Long depotId;
    /**
     * 调拨时，对方仓库Id
     */
    private Long anotherDepotId;
    /**
     * 商品税率
     */
    private BigDecimal taxRate;
    /**
     * 商品税额
     */
    private BigDecimal taxMoney;
    /**
     * 商品价税合计
     */
    private BigDecimal taxLastMoney;
    /**
     * 商品类型
     */
    private String materialType;
    /**
     * 商品序列号列表
     */
    private String snList;
    /**
     * 商品批号
     */
    private String batchNumber;
    /**
     * 商品有效日期
     */
    private Date expirationDate;
    /**
     * 商品关联明细id
     */
    private Long linkId;
    /**
     * 删除标记，0未删除，1删除
     */
    private String deleteFlag;

    public DepotItem(Long id, Long headerId, Long materialId, Long materialExtendId, String materialUnit, String sku, BigDecimal operNumber, BigDecimal basicNumber, BigDecimal unitPrice, BigDecimal taxUnitPrice, BigDecimal allPrice, String remark, Long depotId, Long anotherDepotId, BigDecimal taxRate, BigDecimal taxMoney, BigDecimal taxLastMoney, String materialType, String snList, String batchNumber, Date expirationDate, Long linkId, String deleteFlag) {
        this.id = id;
        this.headerId = headerId;
        this.materialId = materialId;
        this.materialExtendId = materialExtendId;
        this.materialUnit = materialUnit;
        this.sku = sku;
        this.operNumber = operNumber;
        this.basicNumber = basicNumber;
        this.unitPrice = unitPrice;
        this.taxUnitPrice = taxUnitPrice;
        this.allPrice = allPrice;
        this.remark = remark;
        this.depotId = depotId;
        this.anotherDepotId = anotherDepotId;
        this.taxRate = taxRate;
        this.taxMoney = taxMoney;
        this.taxLastMoney = taxLastMoney;
        this.materialType = materialType;
        this.snList = snList;
        this.batchNumber = batchNumber;
        this.expirationDate = expirationDate;
        this.linkId = linkId;
        this.deleteFlag = deleteFlag;
    }

    public DepotItem() {
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

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getMaterialExtendId() {
        return materialExtendId;
    }

    public void setMaterialExtendId(Long materialExtendId) {
        this.materialExtendId = materialExtendId;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit == null ? null : materialUnit.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public BigDecimal getOperNumber() {
        return operNumber;
    }

    public void setOperNumber(BigDecimal operNumber) {
        this.operNumber = operNumber;
    }

    public BigDecimal getBasicNumber() {
        return basicNumber;
    }

    public void setBasicNumber(BigDecimal basicNumber) {
        this.basicNumber = basicNumber;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTaxUnitPrice() {
        return taxUnitPrice;
    }

    public void setTaxUnitPrice(BigDecimal taxUnitPrice) {
        this.taxUnitPrice = taxUnitPrice;
    }

    public BigDecimal getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(BigDecimal allPrice) {
        this.allPrice = allPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public Long getAnotherDepotId() {
        return anotherDepotId;
    }

    public void setAnotherDepotId(Long anotherDepotId) {
        this.anotherDepotId = anotherDepotId;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxMoney() {
        return taxMoney;
    }

    public void setTaxMoney(BigDecimal taxMoney) {
        this.taxMoney = taxMoney;
    }

    public BigDecimal getTaxLastMoney() {
        return taxLastMoney;
    }

    public void setTaxLastMoney(BigDecimal taxLastMoney) {
        this.taxLastMoney = taxLastMoney;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getSnList() {
        return snList;
    }

    public void setSnList(String snList) {
        this.snList = snList == null ? null : snList.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
