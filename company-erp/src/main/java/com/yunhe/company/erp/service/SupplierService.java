package com.yunhe.company.erp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.company.erp.common.bo.SupplierBO;
import com.yunhe.entity.domain.erp.Supplier;


import java.math.BigDecimal;

public interface SupplierService extends IService<Supplier> {
    int updateAdvanceIn(Long supplierId, BigDecimal advanceIn);
    void addSupplier(SupplierBO supplierBO);
}
