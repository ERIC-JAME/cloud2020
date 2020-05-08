package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: zhanxg
 * @create: 2020/4/30 18:08
 */

public interface PaymentService {

    public String paymentInfoOk(Integer id);

    public String paymentInfoTimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
