package com.fengye.springcloud.service;

import com.fengye.springcloud.domain.Storage;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 23:17
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
