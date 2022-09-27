package com.yunhe.common.rabbitmq.dynamic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/9/27 17:42
 */
@ConfigurationProperties(prefix = "spring.rabbitmq")
@Data
public class RabbitModuleProperties {

    private List<RabbitModuleInfo> modules;

}
