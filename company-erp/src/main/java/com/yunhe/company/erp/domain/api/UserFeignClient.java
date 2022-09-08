package com.yunhe.company.erp.domain.api;

import com.yunhe.common.core.result.Result;
import com.yunhe.company.erp.domain.api.fallback.UserFeignFallbackClient;
import com.yunhe.company.erp.domain.dto.UserAuthDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "company-erp", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/users")
    Result<UserAuthDTO> getUserByUserName(@RequestParam String userName);
}
