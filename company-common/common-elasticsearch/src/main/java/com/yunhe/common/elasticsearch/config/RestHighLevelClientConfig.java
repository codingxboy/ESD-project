package com.yunhe.common.elasticsearch.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName RestHighLevelClientConfig
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/9/22 15:33
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "elasticsearch.rest")
@Configuration
@Slf4j
public class RestHighLevelClientConfig {

    @Setter
    private List<String> clusterNodes;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        HttpHost[] hosts = clusterNodes.stream()
                // eg: new HttpHost("127.0.0.1", 9200, "http")
                .map(this::buildHttpHost)
                .toArray(HttpHost[]::new);
        return new RestHighLevelClient(RestClient.builder(hosts));
    }

    private HttpHost buildHttpHost(String node) {
        String[] nodeInfo = node.split(":");
        log.info("elasticsearch的ip为: "+nodeInfo[0].trim());
        log.info("elasticsearch的端口为: "+Integer.parseInt(nodeInfo[1].trim()));
        return new HttpHost(nodeInfo[0].trim(), Integer.parseInt(nodeInfo[1].trim()), "http");
    }
}
