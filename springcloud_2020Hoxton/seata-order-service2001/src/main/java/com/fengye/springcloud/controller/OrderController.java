package com.fengye.springcloud.controller;

import com.fengye.springcloud.domain.CommonResult;
import com.fengye.springcloud.domain.Order;
import com.fengye.springcloud.service.OrderServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 22:25
 */
@RestController
public class OrderController {

    @Autowired
    private OrderServcice orderServcice;

    @RequestMapping("/order/create")
    public CommonResult<Order> createOrder(Order order){
        orderServcice.create(order);
        return new CommonResult<>(200, "订单创建成功！", order);
    }
}
