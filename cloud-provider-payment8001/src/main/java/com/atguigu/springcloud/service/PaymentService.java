package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zhanxg
 * @create 2020/4/29 14:35
 */
public interface PaymentService {
    //xie
    public Integer create(Payment payment);
    //du
    public Payment getPaymentByid(@Param("id") long id);
}
