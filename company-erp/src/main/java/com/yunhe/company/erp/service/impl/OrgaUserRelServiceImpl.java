package com.yunhe.company.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.base.BaseEntity;
import com.yunhe.company.erp.generator.mappers.OrgaUserRelMapper;
import com.yunhe.company.erp.service.OrgaUserRelService;
import com.yunhe.entity.domain.erp.OrgaUserRel;
import com.yunhe.entity.domain.erp.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName OrgaUserRelServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/8 16:24
 * @Version 1.0
 */
@Service
public class OrgaUserRelServiceImpl extends ServiceImpl<OrgaUserRelMapper, OrgaUserRel> implements OrgaUserRelService {

    @Resource
    private UserServiceImpl userServiceImpl;
    /**
     * @description: 新增机构用户关联关系
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/8 16:48
     */
    @Override
    public OrgaUserRel addOrgaUserRel(OrgaUserRel orgaUserRel) {
        userServiceImpl.getCurrentUser();
        return null;
    }
}
