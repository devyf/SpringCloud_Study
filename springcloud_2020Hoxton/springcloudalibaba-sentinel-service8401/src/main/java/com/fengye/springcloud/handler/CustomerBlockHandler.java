package com.fengye.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fengye.springcloud.entities.CommonResult;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 0:09
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444, "按客户自定义，global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444, "按客户自定义，global handlerException----2");
    }
}
