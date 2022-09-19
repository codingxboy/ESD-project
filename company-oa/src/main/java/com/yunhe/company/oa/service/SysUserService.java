package com.yunhe.company.oa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.company.oa.domain.dto.UserAuthDTO;
import com.yunhe.entity.domain.oa.SysUser;


/**
 * @description:
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/9/16 10:15
 */

public interface SysUserService extends IService<SysUser> {

    UserAuthDTO getUserByUserName(String userName);
}
