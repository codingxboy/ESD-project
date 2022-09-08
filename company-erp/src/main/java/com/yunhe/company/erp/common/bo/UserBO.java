package com.yunhe.company.erp.common.bo;
import com.yunhe.entity.domain.erp.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserBO
 * @Description TODO 用户注册BO类
 * @Author xiaozuqin
 * @Date 2022/7/27 16:52
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserBO extends User {
    //机构简称
    private String orgAbr;
    //机构id
    private Long orgaId;
    //用户在部门中排序
    private String userBlngOrgaDsplSeq;
    //机构用户关联关系id
    private Long orgaUserRelId;
    //角色id
    private Long roleId;
    //角色名称
    private String roleName;
    //用户类型
    private String userType;
    //用户数量总和
    private Integer userNumLimit;

    public UserBO(){}
    public UserBO(String userName, Integer departId, String email,String description,String loginName, String phoneNum,String position, String remark, Long id,String orgAbr, Long orgaId, String userBlngOrgaDsplSeq, Long orgaUserRelId, Long roleId, String roleName, String userType, Integer userNumLimit) {
        super(userName, departId,email,description,loginName, phoneNum,position, remark,id);
        this.orgAbr = orgAbr;
        this.orgaId = orgaId;
        this.userBlngOrgaDsplSeq = userBlngOrgaDsplSeq;
        this.orgaUserRelId = orgaUserRelId;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userType = userType;
        this.userNumLimit = userNumLimit;
    }

    public String getOrgAbr() {
        return orgAbr;
    }

    public void setOrgAbr(String orgAbr) {
        this.orgAbr = orgAbr;
    }

    public Long getOrgaId() {
        return orgaId;
    }

    public void setOrgaId(Long orgaId) {
        this.orgaId = orgaId;
    }

    public String getUserBlngOrgaDsplSeq() {
        return userBlngOrgaDsplSeq;
    }

    public void setUserBlngOrgaDsplSeq(String userBlngOrgaDsplSeq) {
        this.userBlngOrgaDsplSeq = userBlngOrgaDsplSeq;
    }

    public Long getOrgaUserRelId() {
        return orgaUserRelId;
    }

    public void setOrgaUserRelId(Long orgaUserRelId) {
        this.orgaUserRelId = orgaUserRelId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserNumLimit() {
        return userNumLimit;
    }

    public void setUserNumLimit(Integer userNumLimit) {
        this.userNumLimit = userNumLimit;
    }
}
