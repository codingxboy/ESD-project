package com.yunhe.company.erp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.company.erp.common.bo.DepotHeadBO;
import com.yunhe.entity.domain.erp.DepotHead;


public interface DepotHeadService extends IService<DepotHead> {
    void addDepotHead(DepotHeadBO depotHeadBO);
}



