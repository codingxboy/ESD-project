package com.yunhe.company.oa.domain.api;


import com.yunhe.common.core.result.Result;

import com.yunhe.company.oa.domain.api.fallback.UserFeignFallbackClient;
import com.yunhe.company.oa.domain.dto.UserAuthDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "company-oa", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/users/username/{username}")
    Result<UserAuthDTO> getUserByUserName(@PathVariable String username);
}
