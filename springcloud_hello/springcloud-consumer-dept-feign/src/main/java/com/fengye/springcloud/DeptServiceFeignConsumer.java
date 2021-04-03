package com.fengye.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  //标识这是一个eureka的client客户端
@EnableFeignClients(basePackages = {"com.fengye.springcloud"})  //扫描哪个包下面的Feign注解
public class DeptServiceFeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceFeignConsumer.class, args);
    }
}
