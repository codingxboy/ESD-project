package com.yunhe.entity.domain.erp;

public class Role {
    private Long id;

    private String name;

    private String type;

    private String value;

    private String description;

    private String deleteFlag;

    public Role(Long id, String name, String type, String value, String description, String deleteFlag) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = description;
        this.deleteFlag = deleteFlag;
    }

    public Role() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
