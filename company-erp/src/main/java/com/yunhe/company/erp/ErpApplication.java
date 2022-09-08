package com.yunhe.company.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ErpApplication
 * @Description TODO erp服务
 * @Author xiaozuqin
 * @Date 2022/7/14 14:48
 * @Version 1.0
 */
@MapperScan("com.yunhe.company.erp.generator.mappers")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ErpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }
}
