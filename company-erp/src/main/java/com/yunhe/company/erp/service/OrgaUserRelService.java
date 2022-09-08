package com.yunhe.company.erp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.entity.domain.erp.OrgaUserRel;


/**
 * @ClassName OrgaUserRelService
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/8 16:22
 * @Version 1.0
 */
public interface OrgaUserRelService extends IService<OrgaUserRel> {
    OrgaUserRel addOrgaUserRel(OrgaUserRel orgaUserRel);
}
