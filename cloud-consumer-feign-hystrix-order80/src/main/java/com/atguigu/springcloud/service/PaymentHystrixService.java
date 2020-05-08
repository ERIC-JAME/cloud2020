package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: zhanxg
 * @create: 2020/4/30 18:47
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @RequestMapping(value = "/payment/hystrix/ok/{id}",method = RequestMethod.GET)
    public String paymentInfoOk(@PathVariable("id")Integer id);

    @RequestMapping(value = "/payment/hystrix/timeout/{id}",method = RequestMethod.GET)
    public String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
