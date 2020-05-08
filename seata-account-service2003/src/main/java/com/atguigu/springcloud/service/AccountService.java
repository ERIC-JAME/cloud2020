package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author: zhanxg
 * @create: 2020/5/8 10:29
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userid 用户的id
     * @param money 金额
     */
    void decrease(@RequestParam("userId") Long userid, @RequestParam("money")BigDecimal money);
}
