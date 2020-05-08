package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: zhanxg
 * @create: 2020/4/30 9:57
 */
@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.prot}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul",method = RequestMethod.GET)
    public String paymentzk(){
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
