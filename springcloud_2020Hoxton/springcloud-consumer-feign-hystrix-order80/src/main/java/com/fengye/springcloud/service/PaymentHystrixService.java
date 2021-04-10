package com.fengye.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
//统一服务降级的方法是PaymentFallbackService这个类
@FeignClient(value = "SPRINGCLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    @RequestMapping(value = "/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id);

    @RequestMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
