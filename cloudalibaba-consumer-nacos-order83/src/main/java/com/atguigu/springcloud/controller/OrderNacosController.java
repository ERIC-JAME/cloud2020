package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhanxg
 * @create: 2020/5/6 15:46
 */
@RestController
public class OrderNacosController {

    //url地址可配在yml文件里面
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverURL+"payment/nacos/"+id,String.class);
    }
}
