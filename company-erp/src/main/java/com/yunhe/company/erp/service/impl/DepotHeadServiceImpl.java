package com.yunhe.company.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.core.constants.ExceptionConstants;
import com.yunhe.common.core.util.StringUtil;
import com.yunhe.common.core.util.UuidUtil;
import com.yunhe.common.web.exception.BizException;
import com.yunhe.company.erp.common.bo.DepotHeadBO;

import com.yunhe.company.erp.generator.mappers.DepotHeadMapper;
import com.yunhe.company.erp.generator.mappers.DepotItemMapper;
import com.yunhe.company.erp.service.DepotHeadService;
import com.yunhe.entity.domain.erp.DepotHead;
import com.yunhe.entity.domain.erp.DepotHeadExample;
import com.yunhe.entity.domain.erp.DepotItem;
import com.yunhe.entity.domain.erp.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName DepotHeadServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/18 17:37
 * @Version 1.0
 */
@Service
public class DepotHeadServiceImpl extends ServiceImpl<DepotHeadMapper, DepotHead> implements DepotHeadService{

    private Logger logger = LoggerFactory.getLogger(DepotHeadServiceImpl.class);

    @Resource
    private DepotHeadMapper depotHeadMapper;
    @Resource
    private DepotItemMapper depotItemMapper;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @Override
    public void addDepotHead(DepotHeadBO depotHeadBO) {
        //新增主表信息数据
        depotHeadBO.getDepotHead().setDefaultNumber(BusinessConstants.BILLS_TYPE_LSD+ UuidUtil.getDateFormat());
        depotHeadBO.getDepotHead().setNumber(BusinessConstants.BILLS_TYPE_LSD+ UuidUtil.getDateFormat());
        if (BusinessConstants.SUB_TYPE_PURCHASE.equals(depotHeadBO.getDepotHead().getSubType())||BusinessConstants.SUB_TYPE_PURCHASE_RETURN.equals(depotHeadBO.getDepotHead().getSubType())||
        BusinessConstants.SUB_TYPE_SALES.equals(depotHeadBO.getDepotHead().getSubType())||BusinessConstants.SUB_TYPE_SALES_RETURN.equals(depotHeadBO.getDepotHead().getSubType())){
            //结算账户校验
            if (StringUtils.isEmpty(depotHeadBO.getDepotHead().getAccountMoneyList())&&depotHeadBO.getDepotHead().getAccountId()==null){
                throw new BizException(ExceptionConstants.DEPOT_HEAD_ACCOUNT_FAILED_MSG);
            }
            //欠款校验
            if (depotHeadBO.getDepotHead().getChangeAmount().abs().compareTo(depotHeadBO.getDepotHead().getDiscountLastMoney().add(depotHeadBO.getDepotHead().getOtherMoney()))!=0){
                throw new BizException(ExceptionConstants.DEPOT_HEAD_BACK_BILL_DEBT_FAILED_MSG);
            }
        }
        //获取当前用户登录的信息
        User user = userServiceImpl.getCurrentUser();
        depotHeadBO.getDepotHead().setCreatorBy(user==null?null:user.getUserName());
        depotHeadBO.getDepotHead().setCreateTime(LocalDateTime.now());
        if (StringUtils.isEmpty(depotHeadBO.getDepotHead().getStatus())) {
            depotHeadBO.getDepotHead().setStatus(BusinessConstants.PURCHASE_STATUS_UN_AUDIT);
        }
        depotHeadBO.getDepotHead().setPurchaseStatus(BusinessConstants.PURCHASE_STATUS_UN_AUDIT);
        if (StringUtils.isNotBlank(depotHeadBO.getDepotHead().getAccountMoneyList())){
            //校验账户结算金额
            BigDecimal manyAccountSum = StringUtil.getArrSum(depotHeadBO.getDepotHead().getAccountMoneyList().split(",")).abs();
            if (manyAccountSum.compareTo(depotHeadBO.getDepotHead().getChangeAmount().abs())!=0){
                throw new BizException(ExceptionConstants.DEPOT_HEAD_MANY_ACCOUNT_FAILED_MSG);
            }
        }
        //校验累计扣减金额是否超出订单中的金额
        if (depotHeadBO.getDepotHead().getDeposit()!=null&&StringUtil.isNotEmpty(depotHeadBO.getDepotHead().getLinkNumber())){
            BigDecimal finishDeposit = depotHeadMapper.getFinishDepositByNumberExceptCurrent(depotHeadBO.getDepotHead().getLinkNumber(), depotHeadBO.getDepotHead().getNumber());
            //订单中的订金
            DepotHead depotHead = new DepotHead();
            DepotHeadExample depotHeadExample = new DepotHeadExample();
            depotHeadExample.createCriteria().andNumberEqualTo(depotHeadBO.getDepotHead().getNumber()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            if (depotHeadMapper.selectByExample(depotHeadExample)!=null&&depotHeadMapper.selectByExample(depotHeadExample).size()>0){
                depotHead=depotHeadMapper.selectByExample(depotHeadExample).get(0);
            }
            BigDecimal changeAmount = depotHead.getChangeAmount();
            if (changeAmount!=null){
                BigDecimal preDeposit = changeAmount.abs();
                if (depotHeadBO.getDepotHead().getDeposit().add(finishDeposit).compareTo(preDeposit)>0){
                    throw new BizException(ExceptionConstants.DEPOT_HEAD_DEPOSIT_OVER_PRE_CODE,ExceptionConstants.DEPOT_HEAD_DEPOSIT_OVER_PRE_MSG);
                }
            }
        }
        depotHeadMapper.insertSelective(depotHeadBO.getDepotHead());
        //入库和出库处理预付款信息
        if (BusinessConstants.PAY_TYPE_PREPAID.equals(depotHeadBO.getDepotHead().getPayType())){
            if (depotHeadBO.getDepotHead().getOrganId()!=null){
                BigDecimal advanceIn = supplierServiceImpl.getById(depotHeadBO.getDepotHead().getOrganId()).getAdvanceIn();
                if (advanceIn.compareTo(depotHeadBO.getDepotHead().getTotalPrice())>=0){
                    supplierServiceImpl.updateAdvanceIn(depotHeadBO.getDepotHead().getOrganId(), BigDecimal.ZERO.subtract(depotHeadBO.getDepotHead().getTotalPrice()));
                }else {
                    throw new BizException(ExceptionConstants.DEPOT_HEAD_MEMBER_PAY_LACK_CODE, ExceptionConstants.DEPOT_HEAD_MEMBER_PAY_LACK_MSG);
                }
            }
        }
        //保存单据子表的信息,TODO 暂时先保存数据，后期修改代码
        if (depotHeadBO.getDepotItemList()!=null&&depotHeadBO.getDepotItemList().size()>0) {
            for (DepotItem depotItem : depotHeadBO.getDepotItemList()) {
                depotItemMapper.insertSelective(depotItem);
            }
        }
    }
}
