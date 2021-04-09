package com.fengye.springcloud.service;

import com.fengye.springcloud.entities.CommonResult;
import com.fengye.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "SPRINGCLOUD-PAYMENT-SERVICE")  //调用的服务提供者的服务名
public interface PaymentFeignService {
    @GetMapping(value = "/payment/getById/{id}")  ///payment/getById/{id}
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);  //对应的是8001服务提供者上面的servcie接口

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
