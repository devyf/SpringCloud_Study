package com.fengye.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fengye.springcloud.entities.CommonResult;
import com.fengye.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 12:47
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")  //1.情况一：未配置fallback方法
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")  //1.情况二：异常处理使用handlerFallback
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")  //2.情况三：blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback",   //3.情况四：blockHandler与fallback同时存在
        exceptionsToIgnore = {IllegalArgumentException.class })  //exceptionsToIgnore表示如果是IllegalArgumentException，则不走fallback兜底处理直接抛异常
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }

        return result;
    }

    //演示：情况四，如果存在sentinel与fallback两者，那么对应sentinel限流、降级被触发就会调用sentinel中的blockHandler
    //对应情况二：兜底方法
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable ex){
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "异常兜底handlerFallback,exception:" + ex.getMessage(), payment);
    }

    //对应情况三：兜底方法
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException blockException){
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "blockHandler-sentinel限流,无此流水：blockException:" + blockException.getMessage(), payment);
    }
}
