package com.yunhe.entity.domain.erp;

import java.math.BigDecimal;

public class MaterialCurrentStock {
    private Long id;

    private Long materialId;

    private Long depotId;

    private BigDecimal currentNumber;

    private String deleteFlag;

    public MaterialCurrentStock(Long id, Long materialId, Long depotId, BigDecimal currentNumber, String deleteFlag) {
        this.id = id;
        this.materialId = materialId;
        this.depotId = depotId;
        this.currentNumber = currentNumber;
        this.deleteFlag = deleteFlag;
    }

    public MaterialCurrentStock() {
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

    public BigDecimal getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(BigDecimal currentNumber) {
        this.currentNumber = currentNumber;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
