package com.fengye.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 22:14
 */
@MapperScan({"com.fengye.springcloud.dao"})
@Configuration
public class MyBatisConfig {
}
