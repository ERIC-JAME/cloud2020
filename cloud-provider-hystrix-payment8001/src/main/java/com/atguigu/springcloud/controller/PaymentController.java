package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/4/30 18:09
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("server.port")
    private String servicePort;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/payment/hystrix/ok/{id}",method = RequestMethod.GET)
    public String paymentInfoOk(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfoOk(id);
        log.info("----result"+servicePort+result);
        return result;
    }

    @RequestMapping(value = "/payment/hystrix/timeout/{id}",method = RequestMethod.GET)
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("----result"+servicePort+result);
        return result;
    }
    //-----服务熔断
    @RequestMapping(value = "/payment/circuit/{id}",method = RequestMethod.GET)
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("----result"+servicePort+result);
        return result;
    }
}
