package com.yunhe.company.oa.domain.api;


import com.yunhe.common.core.result.Result;
import com.yunhe.company.oa.domain.dto.ClientAuthDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "company-oa", contextId = "oauth-client")
public interface OAuthClientFeignClient {

    @GetMapping("/api/v1/oauth-clients/getOAuth2ClientById")
    Result<ClientAuthDTO> getOAuth2ClientById(@RequestParam String clientId);
}
