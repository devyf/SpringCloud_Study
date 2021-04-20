package com.fengye.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //测试自定义的LoadBanlanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
