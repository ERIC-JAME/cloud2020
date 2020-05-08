package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;

/**
 * @author: zhanxg
 * @create: 2020/5/7 19:49
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
