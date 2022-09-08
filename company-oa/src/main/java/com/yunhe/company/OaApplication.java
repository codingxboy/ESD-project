package com.yunhe.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OaApplication
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/22 11:11
 * @Version 1.0
 */
@MapperScan("com.yunhe.company.oa.mappers")
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class OaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OaApplication.class, args);
    }
}
