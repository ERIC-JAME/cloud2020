package com.atguigu.springcloud.controller;

import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/6 15:19
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/nacos/{id}",method = RequestMethod.GET)
    public String getPayment(@PathVariable("id") Integer id){
        return "serverPort:"+serverPort+"\t"+"id:"+id;
    }
}
