package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: zhanxg
 * @create: 2020/4/30 16:19
 */
@Component //组建能扫描
//feign客户端      找哪个微服务的接口
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping(value = "/consumer/payment/get/{id}",method = RequestMethod.GET)
    CommonResult<Payment> getPaymentById(@Param("id") long id);

    @RequestMapping(value = "/consumer/payment/feign/timeout",method = RequestMethod.GET)
    public String paymentFeignTimeOut();
}
