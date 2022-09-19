package com.yunhe.company.oa.service.impl;

import com.yunhe.company.oa.domain.common.utils.GeoIPUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class SysUserServiceImplTest {

    @Test
    public void testIp(){
        System.out.println(GeoIPUtil.getIpInfo("113.118.184.245"));
        System.out.println(GeoIPUtil.getIpInfo("103.249.33.30"));
    }

}
