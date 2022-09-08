package com.yunhe.company.oa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.company.oa.domain.dto.UserAuthDTO;
import com.yunhe.entity.domain.oa.User;



/**
 * @ClassName UserService
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/25 11:51
 * @Version 1.0
 */
public interface UserService extends IService<User> {

    UserAuthDTO getUserByUserName(String userName);
}
