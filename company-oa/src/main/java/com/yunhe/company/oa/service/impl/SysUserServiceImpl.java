package com.yunhe.company.oa.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.company.oa.domain.dto.UserAuthDTO;
import com.yunhe.company.oa.mappers.SysDeptMapper;
import com.yunhe.company.oa.mappers.SysRoleMapper;
import com.yunhe.company.oa.mappers.SysUserMapper;
import com.yunhe.company.oa.service.SysUserService;
import com.yunhe.entity.domain.oa.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @description:
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/9/16 10:14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {
    @Resource
    private SysDeptMapper sysDeptMapper;


    public List<SysUser> getAllUsers(){
        List<SysUser> sysUser = null;
        try {
            sysUser = this.list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return sysUser;
    }

    public List<SysDept> getDepartList(){
        SysDeptExample sysDeptExample = new SysDeptExample();
        sysDeptExample.createCriteria().andDeptNameEqualTo("财务部门");
        return sysDeptMapper.selectByExample(sysDeptExample);
    }

    @Override
    public UserAuthDTO getUserByUserName(String userName) {
        return null;
    }
}
