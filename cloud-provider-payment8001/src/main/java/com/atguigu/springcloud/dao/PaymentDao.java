package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:zhanxg
 * @2020/4/29 14:15
 */
@Mapper
public interface PaymentDao {
    //xie
    public Integer create(Payment payment);
    //du
    public Payment getPaymentByid(@Param("id") long id);
}
