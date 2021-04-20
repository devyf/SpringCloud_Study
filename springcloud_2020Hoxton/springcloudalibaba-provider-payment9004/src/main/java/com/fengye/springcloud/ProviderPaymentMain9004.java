package com.fengye.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 1:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain9004 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain9004.class, args);
    }
}
