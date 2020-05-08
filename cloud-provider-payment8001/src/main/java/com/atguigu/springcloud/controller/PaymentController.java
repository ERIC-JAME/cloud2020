package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhanxg
 * @create 2020/4/29 15:00
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/payment/create",method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment){
        Integer result = paymentService.create(payment);
        log.info("插入结果"+result);
        if(result>1){
        return new CommonResult(200,"插入成功,serverPort "+serverPort,result);
        }else{
            return new CommonResult(444,"插入失败",null);
        }
    }
    @RequestMapping(value = "/payment/get/{id}",method = RequestMethod.GET)
    public CommonResult getPaymentByid(@PathVariable("id") long id){
        Payment result = paymentService.getPaymentByid(id);
        log.info("查询结果"+result.toString());
        if(result !=null){
            return new CommonResult(200,"查询成功 serverPort "+serverPort,result);
        }else{
            return new CommonResult(444,"查询失败",null);
        }
    }

    @RequestMapping(value = "/payment/discovery")
    public Object discovery(){
        //发现具体有的服务
        List<String> services = discoveryClient.getServices();
        for (String service:services) {
            log.info("注册的服务有 "+service);
        }
        //通过注册的服务找到有几个服务注册在里面
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance serviceInstance:instances) {
            //                                    服务id                               服务ip
            log.info("注册的服务有 "+serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+
                    //              服务端口                        服务地址
                    serviceInstance.getPort()+"\t"+serviceInstance.getUri()
            );
        }
        return this.discoveryClient;
    }

    @RequestMapping(value = "/payment/lb",method = RequestMethod.GET)
    public String getPaymentLB(){
        return serverPort;
    }

    @RequestMapping(value = "/payment/feign/timeout",method = RequestMethod.GET)
    public String paymentFeignTimeOut(){
        try {
            //超时
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
