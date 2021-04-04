package com.fengye.springcloud.controller;

import com.fengye.springcloud.pojo.Dept;
import com.fengye.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping("/queryById/{id}")
    /*@HystrixCommand表示一旦调用服务方法失败并抛出了异常信息之后，
    会自动调用@HystrixCommand标注好的fallbackMethod中指定名称的方法*/
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = service.queryById(id);  //模拟当查询不到id或者id信息异常时返回错误异常的提示
        if(null == dept){
            throw new RuntimeException("id=>" + id + "不存在该用户，或者用户信息无法找到！");
        }
        return dept;
    };

    //熔断备选方法：异常回调信息显示
    public Dept processHystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>" + id + "没有对应的信息，null--@Hystrix")
                .setDbSource("no this database in MySQL");
    }
}
