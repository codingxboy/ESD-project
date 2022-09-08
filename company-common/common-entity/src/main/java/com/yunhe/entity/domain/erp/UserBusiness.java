package com.yunhe.entity.domain.erp;

public class UserBusiness {
    private Long id;

    private String type;

    private String keyId;

    private String value;

    private String btnStr;

    private String deleteFlag;

    public UserBusiness(Long id, String type, String keyId, String value, String btnStr, String deleteFlag) {
        this.id = id;
        this.type = type;
        this.keyId = keyId;
        this.value = value;
        this.btnStr = btnStr;
        this.deleteFlag = deleteFlag;
    }

    public UserBusiness() {
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

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId == null ? null : keyId.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getBtnStr() {
        return btnStr;
    }

    public void setBtnStr(String btnStr) {
        this.btnStr = btnStr == null ? null : btnStr.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
