package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author: zhanxg
 * @create 2020/4/29 15:43
 */
@RestController
@Slf4j
public class OrderController {
    //URL
    // private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    //

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalance loadBalance;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/comsumer/payment/create", method = RequestMethod.GET)
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @RequestMapping(value = "/comsumer/payment/get/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {

        //restTemplate.getForObject返回对象为响应体中数据转化成的对象，基本上可以理解为Json
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @RequestMapping(value = "/comsumer/payment/getForEntity/{id}", method = RequestMethod.GET)
    public CommonResult<Payment> getForEntity(@PathVariable("id") long id) {

        //restTemplate.getForEntity返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头，响应状态，响应体
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }

    }

    @RequestMapping(value = "/consumer/payment/lb", method = RequestMethod.GET)
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalance.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }

}
