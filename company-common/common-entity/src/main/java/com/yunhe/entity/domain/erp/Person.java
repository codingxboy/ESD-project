package com.yunhe.entity.domain.erp;

public class Person {
    private Long id;

    private String type;

    private String name;

    private String deleteFlag;

    public Person(Long id, String type, String name, String deleteFlag) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.deleteFlag = deleteFlag;
    }

    public Person() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
