package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author: zhanxg
 * @create: 2020/4/30 21:00
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {

        return "----paymentInfoOk fall back";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {

        return "paymentInfoTimeOut fall back";
    }
}
