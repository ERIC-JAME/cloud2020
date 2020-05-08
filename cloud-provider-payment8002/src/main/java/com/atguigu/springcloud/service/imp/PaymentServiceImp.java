package com.atguigu.springcloud.service.imp;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhanxg
 * @create 2020/4/29 14:36
 */
@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    PaymentService paymentService;
    @Override
    public Integer create(Payment payment) {

        return paymentService.create(payment);
    }

    @Override
    public Payment getPaymentByid(long id) {

        return paymentService.getPaymentByid(id);
    }
}
