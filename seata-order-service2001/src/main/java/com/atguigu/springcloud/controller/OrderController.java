package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/7 19:47
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/create",method = RequestMethod.GET)
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
