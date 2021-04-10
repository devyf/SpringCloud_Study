package com.fengye.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String payment_OK(Integer id) {
        return "-----------PaymentFallbackService fall back payment_OK, o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------PaymentFallbackService paymentInfo_TimeOut, o(╥﹏╥)o";
    }
}
