package com.atguigu.springcloud.service.imp;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: zhanxg
 * @create: 2020/4/30 18:09
 */
@Service
public class PaymentServiceImp implements PaymentService {


    public String paymentInfoOk(Integer id) {

        return "线程池"+Thread.currentThread().getName()+"paymentInfo"+id+"\t"+"ok";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties ={
            @HystrixProperty(name = "execution.isolation.thread.timeoutMilliseconds",value ="3000")
    })
    public String paymentInfoTimeOut(Integer id) {

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"paymentInfoTimeOut"+id+"\t"+"TimeOut";
    }
    public String paymentInfoTimeOutHandler(Integer id) {

        return "线程池"+Thread.currentThread().getName()+"系统繁忙paymentInfoTimeOutHandler"+id+"\t"+"TimeOut";
    }

    //-----服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("----id  不能为负");

        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){

        return "----id  不能为负，请稍后再试";
    }
}
