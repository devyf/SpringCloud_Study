package com.fengye.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfig_3344_StartApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfig_3344_StartApp.class, args);
    }
}
