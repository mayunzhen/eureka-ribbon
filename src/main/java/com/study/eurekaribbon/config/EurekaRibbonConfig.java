package com.study.eurekaribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * EurekaRibbonConfig
 * 应用配置类，初始化 Bean和配置信息
 *
 * @author mayunzhen
 * @version 1.0.0
 */
@Configuration
public class EurekaRibbonConfig {

    @Bean // 初始化 Bean
    @LoadBalanced // 实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}