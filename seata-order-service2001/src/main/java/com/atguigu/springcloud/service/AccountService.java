package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author: zhanxg
 * @create: 2020/5/7 21:29
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 减余额
     * @param id
     * @param money
     * @return
     */
    @RequestMapping(value = "/account/decrease",method = RequestMethod.POST)
    CommonResult decrease(@RequestParam("userId") Long id, @RequestParam("money")BigDecimal money);
}
