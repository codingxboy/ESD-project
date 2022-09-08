package com.yunhe.entity.domain.erp;

import java.math.BigDecimal;

/**
 * @description: 仓库表
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/18 16:49
 */
public class Depot {
    private Long id;

    private String name;

    private String address;

    private BigDecimal warehousing;

    private BigDecimal truckage;

    private Integer type;

    private String sort;

    private String remark;

    private Long principal;

    private String deleteFlag;

    private Boolean isDefault;

    public Depot(Long id, String name, String address, BigDecimal warehousing, BigDecimal truckage, Integer type, String sort, String remark, Long principal, String deleteFlag, Boolean isDefault) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.warehousing = warehousing;
        this.truckage = truckage;
        this.type = type;
        this.sort = sort;
        this.remark = remark;
        this.principal = principal;
        this.deleteFlag = deleteFlag;
        this.isDefault = isDefault;
    }

    public Depot() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getWarehousing() {
        return warehousing;
    }

    public void setWarehousing(BigDecimal warehousing) {
        this.warehousing = warehousing;
    }

    public BigDecimal getTruckage() {
        return truckage;
    }

    public void setTruckage(BigDecimal truckage) {
        this.truckage = truckage;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Long getPrincipal() {
        return principal;
    }

    public void setPrincipal(Long principal) {
        this.principal = principal;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
