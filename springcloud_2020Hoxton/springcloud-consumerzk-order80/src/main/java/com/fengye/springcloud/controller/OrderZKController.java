package com.fengye.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {
    @Resource
    private RestTemplate restTemplate;

    //zookeeper上面的服务名
    public static final String ZK_PAYMENT_URL = "http://springcloud-payment-service";

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentZkInfo(){
        String result = restTemplate.getForObject(ZK_PAYMENT_URL + "/payment/zk", String.class);
        log.info("调用zookeeper服务成功返回：" + result);
        return result;
    }
}
