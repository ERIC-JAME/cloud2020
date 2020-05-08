package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import io.micrometer.core.instrument.Meter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: zhanxg
 * @create: 2020/5/7 14:29
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Payment(1l,"1111"));
        hashMap.put(2L,new Payment(2l,"2222"));
        hashMap.put(3L,new Payment(3l,"3333"));
    }

    @RequestMapping(value = "paymentSQL/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200, "from mysql serverPort: " + serverPort);

        return result;
    }
}
