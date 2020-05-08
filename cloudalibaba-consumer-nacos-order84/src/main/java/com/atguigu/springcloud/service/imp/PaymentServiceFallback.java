package com.atguigu.springcloud.service.imp;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author: zhanxg
 * @create: 2020/5/7 16:05
 */
@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {

        return new CommonResult<>(4444,"服务降级返回，---paymentFallbackService",new Payment(id,"errorService"));
    }
}
