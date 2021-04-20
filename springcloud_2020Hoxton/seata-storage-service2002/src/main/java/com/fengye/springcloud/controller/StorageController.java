package com.fengye.springcloud.controller;

import com.fengye.springcloud.domain.CommonResult;
import com.fengye.springcloud.domain.Storage;
import com.fengye.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 23:23
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult<Storage> decrease(@RequestParam("productId")Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return new CommonResult<>(200, "库存扣减成功！");
    }
}
