package com.fengye.springcloud.service.impl;

import com.fengye.springcloud.dao.AccountDao;
import com.fengye.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 23:46
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------------>account-service中扣减账户余额开始。。。");
        //模拟超时异常，全局事务回滚
        accountDao.decrease(userId, money);
        log.info("------------>account-service中扣减账户余额结束。。。");
    }
}
