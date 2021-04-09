package com.fengye.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {
    @Resource
    private RestTemplate restTemplate;

    //zookeeper上面的服务名
    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentZkInfo(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        log.info("调用consul服务成功返回：" + result);
        return result;
    }
}
