package com.fengye.springcloud.service;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 23:45
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(Long userId, BigDecimal money);
}
