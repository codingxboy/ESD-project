package com.yunhe.company.erp.domain.api.fallback;
import com.yunhe.common.core.result.Result;
import com.yunhe.common.core.result.ResultCode;

import com.yunhe.company.erp.domain.api.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/25 11:10
 */
@Component
@Slf4j
public class UserFeignFallbackClient implements UserFeignClient {

    @Override
    public Result getUserByUserName(String userName) {
        log.error("feign远程调用ERP系统用户服务异常后的降级方法");
        return Result.failed(ResultCode.DEGRADATION);
    }
}
