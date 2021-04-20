package com.fengye.springcloud;

import com.fengye.springcloud.config.DataSourceProxyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 22:21
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  //取消数据源的自动创建
public class SetaOrderMainApp2001 {
    public static void main(String[] args) {
        SpringApplication.run(SetaOrderMainApp2001.class, args);
    }
}
