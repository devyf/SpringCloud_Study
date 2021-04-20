package com.fengye.springcloud.service;

import com.fengye.springcloud.entities.CommonResult;
import com.fengye.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 14:57
 */
@Service
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444, "-------PaymentFallbackService降级方法,无对应id" + id, new Payment(id, ""));
    }
}
