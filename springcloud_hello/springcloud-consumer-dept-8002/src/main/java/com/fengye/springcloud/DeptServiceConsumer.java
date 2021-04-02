package com.fengye.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //标识这是一个eureka的client客户端
public class DeptServiceConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceConsumer.class, args);
    }
}
