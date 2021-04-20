package com.fengye.springcloud.controller;

import com.fengye.springcloud.entities.CommonResult;
import com.fengye.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 1:24
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "2833dkdil23232ke2kdl2d2e1l"));
        hashMap.put(2L, new Payment(2L, "bba3dkdil23232ke2kdlac2e1l"));
        hashMap.put(3L, new Payment(3L, "6833dkde2il23ke32ke2kdd244"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return new CommonResult<>(200, "根据id获取Payment数据成功！from mysql, serverPort:" + serverPort, hashMap.get(id));
    }
}
