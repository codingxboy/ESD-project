package com.yunhe.entity.domain.erp;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@TableName(value = "erp_user")
public class User {
    private Long id;

    private String userName;

    private String loginName;

    private String passWord;

    private String position;

    private String email;

    private String phoneNum;

    private Byte isManager;

    private Byte isSystem;

    private Byte status;

    private String description;

    private String remark;

    private String salt;

    private Integer departId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public Byte getIsManager() {
        return isManager;
    }

    public void setIsManager(Byte isManager) {
        this.isManager = isManager;
    }

    public Byte getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Byte isSystem) {
        this.isSystem = isSystem;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", isManager=" + isManager +
                ", isSystem=" + isSystem +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", remark='" + remark + '\'' +
                ", salt='" + salt + '\'' +
                ", departId=" + departId +
                '}';
    }

    public User(String userName, Integer departId,String loginName, String position, String email, String phoneNum, String description, String remark,Long id) {
        this.userName = userName;
        this.departId = departId;
        this.loginName = loginName;
        this.position = position;
        this.email = email;
        this.phoneNum = phoneNum;
        this.description = description;
        this.remark = remark;
        this.id = id;
    }

    public User(Long id, String userName, String loginName, String passWord, String position, String email, String phoneNum, Byte isManager, Byte isSystem, Byte status, String description, String remark, String salt, Integer departId) {
        this.id = id;
        this.userName = userName;
        this.loginName = loginName;
        this.passWord = passWord;
        this.position = position;
        this.email = email;
        this.phoneNum = phoneNum;
        this.isManager = isManager;
        this.isSystem = isSystem;
        this.status = status;
        this.description = description;
        this.remark = remark;
        this.salt = salt;
        this.departId = departId;
    }
}
