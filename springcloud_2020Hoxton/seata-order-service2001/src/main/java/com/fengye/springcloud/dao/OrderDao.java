package com.fengye.springcloud.dao;

import com.fengye.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 20:53
 */
@Mapper
public interface OrderDao {
    //1.新建订单
    void create(Order order);
    //2.修改订单状态：0到1
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
