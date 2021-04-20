package com.fengye.springcloud.service.impl;

import com.fengye.springcloud.dao.OrderDao;
import com.fengye.springcloud.domain.Order;
import com.fengye.springcloud.service.AccountService;
import com.fengye.springcloud.service.OrderServcice;
import com.fengye.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 21:27
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderServcice {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        //新建订单
        log.info("------>开始新建订单");
        orderDao.create(order);

        //扣减库存
        log.info("------>订单微服务开始调用库存，做扣减count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------>订单微服务开始调用库存，做扣减end...");

        //扣减账户
        log.info("------>订单微服务开始调用账户，做扣减money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------>订单微服务开始调用账户，做扣减end...");

        //修改订单状态，从status：0-1代表已经完成
        log.info("------->修改订单状态开始");
        orderDao.update(order.getUserId(), 1);
        log.info("------->修改订单状态结束");

        log.info("------->下订单流程结束，O(∩_∩)O哈哈~");
    }
}
