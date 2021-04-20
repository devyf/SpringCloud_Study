package com.fengye.springcloud.controller;

import com.fengye.springcloud.entities.CommonResult;
import com.fengye.springcloud.entities.Payment;
import com.fengye.springcloud.mydefinedlb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    //请求封装url地址：前面注意需要加http://
    //public static final String PROVIDER_PAYMENT_URL = "http://localhost:8001";
    //使用集群provider8001/8002之后，只需要通过服务名进行识别url地址，不再关联端口号的单个微服务
    public static final String PROVIDER_PAYMENT_URL = "http://SPRINGCLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PROVIDER_PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/create_post")
    public CommonResult createPost(Payment payment){
        return restTemplate.postForEntity(PROVIDER_PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PROVIDER_PAYMENT_URL + "/payment/getById/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getPaymentByIdPost(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PROVIDER_PAYMENT_URL + "/payment/getById/" + id, CommonResult.class);
        //返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            log.info(responseEntity.getStatusCode() + "\t" + responseEntity.getHeaders());
            return responseEntity.getBody();
        }else {
            return new CommonResult<>(444, "操作失败！");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance instance = loadBalancer.instances(instances);
        int port = instance.getPort();
        return String.valueOf(port);
    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PROVIDER_PAYMENT_URL + "/payment/zipkin", String.class);
    }

}
