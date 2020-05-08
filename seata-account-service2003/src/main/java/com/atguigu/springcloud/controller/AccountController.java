package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.damain.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: zhanxg
 * @create: 2020/5/8 10:47
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){

        accountService.decrease(userId,money);

        return new CommonResult<>(200,"扣减账户余额成功");
    }
}
