package com.yunhe.company.oa.controller;
import com.yunhe.common.core.result.Result;
import com.yunhe.company.oa.domain.dto.ClientAuthDTO;
//import com.yunhe.company.oa.service.OauthClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OauthClientController
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/26 22:21
 * @Version 1.0
 */
@Api(tags = "OA系统客户端服务管理")
@RestController
@RequestMapping("/api/v1/oauth-clients")
@RequiredArgsConstructor
public class OauthClientController {

//    private final OauthClientService oauthClientService;

    @ApiOperation(value = "获取 OAuth2 客户端认证信息")
    @GetMapping("/getOAuth2ClientById")
    public Result<ClientAuthDTO> getOAuth2ClientById(@RequestParam String clientId){
//        OauthClient oauthClient = oauthClientService.getById(clientId);
//        ClientAuthDTO clientAuthDTO = new ClientAuthDTO();
//        BeanUtils.copyProperties(oauthClient, clientAuthDTO);
        return Result.success();
    }
}
