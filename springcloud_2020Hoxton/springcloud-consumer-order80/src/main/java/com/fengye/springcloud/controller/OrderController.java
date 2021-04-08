package com.fengye.springcloud.controller;

import com.fengye.springcloud.entities.CommonResult;
import com.fengye.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    //请求封装url地址：前面注意需要加http://
    //public static final String PROVIDER_PAYMENT_URL = "http://localhost:8001";
    //使用集群provider8001/8002之后，只需要通过服务名进行识别url地址，不再关联端口号的单个微服务
    public static final String PROVIDER_PAYMENT_URL = "http://SPRINGCLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PROVIDER_PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PROVIDER_PAYMENT_URL + "/payment/getById/" + id, CommonResult.class);
    }
}
