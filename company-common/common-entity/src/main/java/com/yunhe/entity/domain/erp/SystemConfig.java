package com.yunhe.entity.domain.erp;

public class SystemConfig {
    private Long id;

    private String companyName;

    private String companyContacts;

    private String companyAddress;

    private String companyTel;

    private String companyFax;

    private String companyPostCode;

    private String saleAgreement;

    private String depotFlag;

    private String customerFlag;

    private String minusStockFlag;

    private String purchaseBySaleFlag;

    private String deleteFlag;

    public SystemConfig(Long id, String companyName, String companyContacts, String companyAddress, String companyTel, String companyFax, String companyPostCode, String saleAgreement, String depotFlag, String customerFlag, String minusStockFlag, String purchaseBySaleFlag, String deleteFlag) {
        this.id = id;
        this.companyName = companyName;
        this.companyContacts = companyContacts;
        this.companyAddress = companyAddress;
        this.companyTel = companyTel;
        this.companyFax = companyFax;
        this.companyPostCode = companyPostCode;
        this.saleAgreement = saleAgreement;
        this.depotFlag = depotFlag;
        this.customerFlag = customerFlag;
        this.minusStockFlag = minusStockFlag;
        this.purchaseBySaleFlag = purchaseBySaleFlag;
        this.deleteFlag = deleteFlag;
    }

    public SystemConfig() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyContacts() {
        return companyContacts;
    }

    public void setCompanyContacts(String companyContacts) {
        this.companyContacts = companyContacts == null ? null : companyContacts.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax == null ? null : companyFax.trim();
    }

    public String getCompanyPostCode() {
        return companyPostCode;
    }

    public void setCompanyPostCode(String companyPostCode) {
        this.companyPostCode = companyPostCode == null ? null : companyPostCode.trim();
    }

    public String getSaleAgreement() {
        return saleAgreement;
    }

    public void setSaleAgreement(String saleAgreement) {
        this.saleAgreement = saleAgreement == null ? null : saleAgreement.trim();
    }

    public String getDepotFlag() {
        return depotFlag;
    }

    public void setDepotFlag(String depotFlag) {
        this.depotFlag = depotFlag == null ? null : depotFlag.trim();
    }

    public String getCustomerFlag() {
        return customerFlag;
    }

    public void setCustomerFlag(String customerFlag) {
        this.customerFlag = customerFlag == null ? null : customerFlag.trim();
    }

    public String getMinusStockFlag() {
        return minusStockFlag;
    }

    public void setMinusStockFlag(String minusStockFlag) {
        this.minusStockFlag = minusStockFlag == null ? null : minusStockFlag.trim();
    }

    public String getPurchaseBySaleFlag() {
        return purchaseBySaleFlag;
    }

    public void setPurchaseBySaleFlag(String purchaseBySaleFlag) {
        this.purchaseBySaleFlag = purchaseBySaleFlag == null ? null : purchaseBySaleFlag.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
