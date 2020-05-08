package com.atguigu.springcloud.service;

/**
 * @author: zhanxg
 * @create: 2020/5/7 16:04
 */

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.imp.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 在feign的注册中心找到名字nacos-payment-provider 的提供者
 * 然后根据路径找到对应的服务
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @RequestMapping(value = "/paymentSQL/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
