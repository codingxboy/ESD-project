package com.yunhe.company.erp.common.bo;

import com.yunhe.entity.domain.erp.DepotHead;
import com.yunhe.entity.domain.erp.DepotItem;
import lombok.Data;

import java.util.List;

/**
 * @ClassName DepotHeadBO
 * @Description TODO 新增单据主表BO对象
 * @Author xiaozuqin
 * @Date 2022/8/2 13:00
 * @Version 1.0
 */
@Data
public class DepotHeadBO {
    private DepotHead depotHead;
    private List<DepotItem> depotItemList;
}
