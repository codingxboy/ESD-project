package com.yunhe.company.erp.common.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName SupplierBO
 * @Description TODO 供应商对象
 * @Author xiaozuqin
 * @Date 2022/8/19 17:10
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierBO {
    private String supplier;

    private String contacts;

    private String phoneNum;

    private String email;

    private String description;

    private BigDecimal advanceIn;

    private BigDecimal beginNeedPay;

    private String fax;

    private String mobilePhone;

    private String address;

    private String taxNum;

    private String bankName;

    private String accountNumber;

    private BigDecimal taxRate;
}
