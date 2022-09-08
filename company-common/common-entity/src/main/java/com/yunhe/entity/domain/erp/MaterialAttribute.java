package com.yunhe.entity.domain.erp;

public class MaterialAttribute {
    private Long id;

    private String attributeField;

    private String attributeName;

    private String attributeValue;

    private String deleteFlag;

    public MaterialAttribute(Long id, String attributeField, String attributeName, String attributeValue, String deleteFlag) {
        this.id = id;
        this.attributeField = attributeField;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.deleteFlag = deleteFlag;
    }

    public MaterialAttribute() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttributeField() {
        return attributeField;
    }

    public void setAttributeField(String attributeField) {
        this.attributeField = attributeField == null ? null : attributeField.trim();
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue == null ? null : attributeValue.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
