package com.fengye.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringBeanConfig {
    @Bean
    @LoadBalanced  //Ribbon基于客户端做负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
