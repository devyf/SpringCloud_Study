package com.fengye.springcloud.controller;

import com.fengye.springcloud.pojo.Dept;
import com.fengye.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService service;

    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    };

    @GetMapping("/queryById/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return service.queryById(id);
    };

    @GetMapping("/queryAll")
    public List<Dept> queryAll(){
        return service.queryAll();
    };
}
