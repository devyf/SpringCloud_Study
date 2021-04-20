package com.fengye.springcloud.service.impl;

import com.fengye.springcloud.dao.StorageDao;
import com.fengye.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 23:18
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(@Param("productId") Long productId, @Param("count") Integer count) {
        log.info("------>库存微服务开始调用库存service，做扣减count操作。。。");
        storageDao.decrease(productId, count);
        log.info("------>库存微服务开始调用库存service结束。。。");
    }
}
