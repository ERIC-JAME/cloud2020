package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author: zhanxg
 * @create: 2020/4/30 18:57
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @RequestMapping(value = "/consumer/payment/hystrix/ok/{id}",method = RequestMethod.GET)
    public String paymentInfoOk(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfoOk(id);
        return result;
    }

    @RequestMapping(value = "/consumer/payment/hystrix/timeout/{id}",method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties ={
//            @HystrixProperty(name = "execution.isolation.thread.timeoutMilliseconds",value ="1500")
//    })
    @HystrixCommand
    public String paymentInfoTimeOut(Integer id) {
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        return result;
    }
    public String paymentInfoTimeOutHandler(Integer id) {

        return "线程池系统繁忙------";
    }
    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){

        return "Global异常处理信息，请稍后再试";
    }
}
