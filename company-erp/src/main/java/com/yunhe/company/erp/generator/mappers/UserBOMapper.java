package com.yunhe.company.erp.generator.mappers;


import com.yunhe.company.erp.common.bo.UserBO;
import com.yunhe.company.erp.generator.vo.TreeNodeEx;
import com.yunhe.entity.domain.erp.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserBOMapper {

    List<UserBO> selectByConditionUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName);

    List<User> getUserListByUserNameOrLoginName(@Param("userName") String userName,
                                                @Param("loginName") String loginName);

    int batDeleteOrUpdateUser(@Param("ids") String ids[], @Param("status") byte status);

    List<TreeNodeEx> getNodeTree();
    List<TreeNodeEx> getNextNodeTree(Map<String, Object> parameterMap);
}
