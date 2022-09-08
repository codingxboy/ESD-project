package com.yunhe.company.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.web.exception.BizException;
import com.yunhe.company.erp.generator.mappers.FunctionMapper;
import com.yunhe.company.erp.service.FunctionService;
import com.yunhe.entity.domain.erp.Function;
import com.yunhe.entity.domain.erp.FunctionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName FunctionServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/7/26 17:29
 * @Version 1.0
 */
@Service
public class FunctionServiceImpl extends ServiceImpl<FunctionMapper, Function> implements FunctionService {
    @Resource
    private FunctionMapper functionMapper;
    @Override
    public List<Function> getFunction() {
        FunctionExample functionExample = new FunctionExample();
        functionExample.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Function> functionList=null;
        try {
            functionList=functionMapper.selectByExample(functionExample);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BizException("数据查询异常", exception);
        }
        return functionList;
    }
}
