package com.yunhe.company.oa.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.company.oa.domain.dto.ClientAuthDTO;
import com.yunhe.company.oa.domain.dto.UserAuthDTO;
import com.yunhe.company.oa.mappers.RoleMapper;
import com.yunhe.company.oa.mappers.UserMapper;
import com.yunhe.company.oa.mappers.UserRoleMapper;
import com.yunhe.company.oa.service.UserService;
import com.yunhe.entity.domain.oa.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/25 11:52
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public UserAuthDTO getUserByUserName(String userName) {
//        User user;
//        UserAuthDTO userAuthDTO = new UserAuthDTO();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> usersList = userMapper.selectByExample(userExample);
        if (usersList.size() > 0) {
            Long userId = usersList.get(0).getUserId();
            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(userId);
            Long roleId = userRoleMapper.selectByExample(userRoleExample).get(0).getRoleId();
            RoleExample roleExample = new RoleExample();
            roleExample.createCriteria().andRoleIdEqualTo(roleId);
            List<String> releList = Arrays.asList(roleMapper.selectByExample(roleExample).get(0).getRoleKey());
//            userAuthDTO.setUserId(usersList.get(0).getUserId());
            return UserAuthDTO.builder().userId(usersList.get(0).getUserId())
                    .userName(usersList.get(0).getUserName())
                    .deptId(usersList.get(0).getDeptId())
                    .passWord(usersList.get(0).getPassWord())
                    .roles(releList)
                    .status(Integer.parseInt(usersList.get(0).getStatus()))
                    .build();
        }
        return null;
    }
}
