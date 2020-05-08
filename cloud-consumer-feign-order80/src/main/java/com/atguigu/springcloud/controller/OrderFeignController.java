package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/4/30 16:27
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
   private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/consumer/payment/get/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){

        return paymentFeignService.getPaymentById(id);
    }
}
