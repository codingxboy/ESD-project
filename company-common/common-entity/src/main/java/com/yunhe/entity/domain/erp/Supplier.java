package com.yunhe.entity.domain.erp;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class Supplier {
    private Long id;

    private String supplier;

    private String contacts;

    private String phoneNum;

    private String email;

    private String description;

    private Byte isSystem;

    private String type;

    private Boolean enabled;

    private BigDecimal advanceIn;

    private BigDecimal beginNeedGet;

    private BigDecimal beginNeedPay;

    private BigDecimal allNeedGet;

    private BigDecimal allNeedPay;

    private String fax;

    private String mobilePhone;

    private String address;

    private String taxNum;

    private String bankName;

    private String accountNumber;

    private BigDecimal taxRate;

    private String deleteFlag;

    public Supplier(Long id, String supplier, String contacts, String phoneNum, String email, String description, Byte isSystem, String type, Boolean enabled, BigDecimal advanceIn, BigDecimal beginNeedGet, BigDecimal beginNeedPay, BigDecimal allNeedGet, BigDecimal allNeedPay, String fax, String mobilePhone, String address, String taxNum, String bankName, String accountNumber, BigDecimal taxRate, String deleteFlag) {
        this.id = id;
        this.supplier = supplier;
        this.contacts = contacts;
        this.phoneNum = phoneNum;
        this.email = email;
        this.description = description;
        this.isSystem = isSystem;
        this.type = type;
        this.enabled = enabled;
        this.advanceIn = advanceIn;
        this.beginNeedGet = beginNeedGet;
        this.beginNeedPay = beginNeedPay;
        this.allNeedGet = allNeedGet;
        this.allNeedPay = allNeedPay;
        this.fax = fax;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.taxNum = taxNum;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.taxRate = taxRate;
        this.deleteFlag = deleteFlag;
    }

    public Supplier() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Byte isSystem) {
        this.isSystem = isSystem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getAdvanceIn() {
        return advanceIn;
    }

    public void setAdvanceIn(BigDecimal advanceIn) {
        this.advanceIn = advanceIn;
    }

    public BigDecimal getBeginNeedGet() {
        return beginNeedGet;
    }

    public void setBeginNeedGet(BigDecimal beginNeedGet) {
        this.beginNeedGet = beginNeedGet;
    }

    public BigDecimal getBeginNeedPay() {
        return beginNeedPay;
    }

    public void setBeginNeedPay(BigDecimal beginNeedPay) {
        this.beginNeedPay = beginNeedPay;
    }

    public BigDecimal getAllNeedGet() {
        return allNeedGet;
    }

    public void setAllNeedGet(BigDecimal allNeedGet) {
        this.allNeedGet = allNeedGet;
    }

    public BigDecimal getAllNeedPay() {
        return allNeedPay;
    }

    public void setAllNeedPay(BigDecimal allNeedPay) {
        this.allNeedPay = allNeedPay;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum == null ? null : taxNum.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
