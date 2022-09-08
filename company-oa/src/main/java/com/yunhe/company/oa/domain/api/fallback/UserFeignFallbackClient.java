package com.yunhe.company.oa.domain.api.fallback;


import com.yunhe.common.core.result.Result;
import com.yunhe.common.core.result.ResultCode;
import com.yunhe.company.oa.domain.api.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author haoxr
 * @createTime 2021/4/24 21:30
 */
@Component
@Slf4j
public class UserFeignFallbackClient implements UserFeignClient {

    @Override
    public Result getUserByUserName(String username) {
        log.error("feign远程调用OA系统用户服务异常后的降级方法");
        return Result.failed(ResultCode.DEGRADATION);
    }
}
