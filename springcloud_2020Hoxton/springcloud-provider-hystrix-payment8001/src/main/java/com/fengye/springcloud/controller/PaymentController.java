package com.fengye.springcloud.controller;

import com.fengye.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    public String serverPort;

    @RequestMapping(value = "/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        String infoOk = paymentService.paymentInfo_OK(id);
        log.info("******result" + infoOk);
        return infoOk;
    }

    @RequestMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String infoTimeOut = paymentService.paymentInfo_TimeOut(id);
        log.info("******result" + infoTimeOut);
        return infoTimeOut;
    }

    //=====服务熔断
    @RequestMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("******result" + result);
        return result;
    }
}
