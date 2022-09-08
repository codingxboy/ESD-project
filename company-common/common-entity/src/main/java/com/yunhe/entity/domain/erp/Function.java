package com.yunhe.entity.domain.erp;

public class Function {
    private Long id;

    private String number;

    private String name;

    private String parentNumber;

    private String url;

    private String component;

    private Boolean state;

    private String sort;

    private Boolean enabled;

    private String type;

    private String pushBtn;

    private String icon;

    private String deleteFlag;

    public Function(Long id, String number, String name, String parentNumber, String url, String component, Boolean state, String sort, Boolean enabled, String type, String pushBtn, String icon, String deleteFlag) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.parentNumber = parentNumber;
        this.url = url;
        this.component = component;
        this.state = state;
        this.sort = sort;
        this.enabled = enabled;
        this.type = type;
        this.pushBtn = pushBtn;
        this.icon = icon;
        this.deleteFlag = deleteFlag;
    }

    public Function() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber == null ? null : parentNumber.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPushBtn() {
        return pushBtn;
    }

    public void setPushBtn(String pushBtn) {
        this.pushBtn = pushBtn == null ? null : pushBtn.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
