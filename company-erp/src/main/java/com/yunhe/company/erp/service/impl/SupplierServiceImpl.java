package com.yunhe.company.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.web.exception.BizException;
import com.yunhe.company.erp.common.bo.SupplierBO;

import com.yunhe.company.erp.generator.mappers.SupplierMapper;
import com.yunhe.company.erp.service.SupplierService;
import com.yunhe.entity.domain.erp.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * @ClassName SupplierServiceImpl
 * @Description TODO 供应商实现类
 * @Author xiaozuqin
 * @Date 2022/8/19 15:51
 * @Version 1.0
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    private Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);
    @Resource
    private SupplierMapper supplierMapper;
    /**
     * @description: 根据id获取供应商信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/19 16:01
     */
    public Supplier getById(Long id){
        Optional<Supplier> supplier = supplierMapper.selectByPrimaryKey(id);
        if (!supplier.isPresent()) {
            logger.error("根据id获取供应商信息异常");
            throw new BizException("根据id获取供应商信息异常");
        }
        return supplier.get();
    }
    /**
     * @description: 根据供应商id更新预付款
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/19 16:18
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    @Override
    public int updateAdvanceIn(Long supplierId, BigDecimal advanceIn) {
        int result = 0;
        Supplier supplier;
        supplier = getById(supplierId);
        if (supplier!=null){
            supplier.setAdvanceIn(supplier.getAdvanceIn().add(advanceIn));
            result=supplierMapper.updateByPrimaryKeySelective(supplier);
        }
        return result;
    }
    /**
     * @description: 增加供应商
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/19 17:14
     */
    @Override
    public void addSupplier(SupplierBO supplierBO) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierBO, supplier);
        supplier.setEnabled(true);
        supplier.setType(BusinessConstants.ORGANIZATION_TYPE_GYS);
        supplierMapper.insertSelective(supplier);
    }
}
