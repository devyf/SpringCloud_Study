package com.fengye.springcloud.controller;

import com.fengye.springcloud.pojo.Dept;
import com.fengye.springcloud.service.DeptService;
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

    @Autowired  //对外暴露一个服务发现的接口
    private DiscoveryClient client;

    @Value("${server.port}")
    private String port;

    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    };

    @GetMapping("/queryById/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = service.queryById(id);
        Dept result = new Dept();
        BeanUtils.copyProperties(dept, result);
        result.setDname(result.getDname() + " data from port=" + port);  //查看员工属于哪个端口
        System.out.println(result.getDname());
        return result;
    };

    @GetMapping("/queryAll")
    public List<Dept> queryAll(){
        return service.queryAll();
    };

    //获取注册进来的微服务的一些消息
    @GetMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>:" + services);
        //得到一个具体的微服务信息，通过具体的微服务Application id
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId()
                            );
        }

        return this.client;
    }
}
