package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: zhanxg
 * @create: 2020/5/7 15:01
 */
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL="http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentservice;

    @RequestMapping(value = "/consumer/fallback/{id}",method = RequestMethod.GET)
    // @SentinelResource(value = "fallback") //没有配置
    // @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback 只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler 只负责sentinel控制台业务违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
        exceptionsToIgnore = {IllegalArgumentException.class}
    )
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class);

        if(id ==4){
            throw new IllegalArgumentException("IllegalArgument,非法的参数异常");

        }else if(result.getData() ==null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    //本例的fallback
    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id,Throwable e){

        Payment payment = new Payment(id,null);
        return new CommonResult<>(444,"兜底的异常handlerback,exception内容"+e.getMessage()+payment);
    }

    //本例是blockHandler
    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockexception){

        Payment payment = new Payment(id,null);
        return new CommonResult<>(444,"blockhandler-sentinel 限流，无此流水 blockexception"+blockexception.getMessage()+payment);
    }

    //==========OpenFeign
    @RequestMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentservice.paymentSQL(id);
    }

}
