package com.yunhe.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.company.oa.mappers.OauthClientMapper;
import com.yunhe.company.oa.service.OauthClientService;
import com.yunhe.entity.domain.oa.OauthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @ClassName OauthClientServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/26 17:25
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class OauthClientServiceImpl extends ServiceImpl<OauthClientMapper,OauthClient> implements OauthClientService {

}
