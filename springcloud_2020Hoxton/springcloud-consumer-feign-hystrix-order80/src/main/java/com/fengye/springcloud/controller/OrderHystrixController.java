package com.fengye.springcloud.controller;

import com.fengye.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局fallbackMethod
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @RequestMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        String infoOk = paymentHystrixService.payment_OK(id);
        return infoOk;
    }

    //服务降级，客户端自己对自己做一个保护
    //客户端出错了，也有自己的兜底方法
    @RequestMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    //@HystrixCommand  -- 不指定特定的使用全局的方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int error = 10 / 0;
        String infoTimeOut = paymentHystrixService.paymentInfo_TimeOut(id);
        return infoTimeOut;
    }

    public String paymentTimeFallbackMethod(Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒钟之后再试或者自己运行出错请检查，o(╥﹏╥)o";
    }

    //下面是全局的fallback方法
    //避免方法膨胀冗余
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }

}
