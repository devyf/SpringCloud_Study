package com.fengye.springcloud.controller;

import com.fengye.springcloud.domain.Account;
import com.fengye.springcloud.domain.CommonResult;
import com.fengye.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: huang
 * @Date: 2021/4/20 23:50
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     * @return
     */
    @RequestMapping("/account/decrease")
    public CommonResult<Account> decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功");
    }
}
