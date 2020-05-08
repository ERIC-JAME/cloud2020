package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zhanxg
 * @create: 2020/5/7 20:10
 */
@Mapper
public interface OrderDao {

    /**
     * 1.新建订单
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 2.修改订单状态 0->1
     * @param id
     * @param status
     * @return
     */
    int update(@Param("userId") Long id,@Param("status") Integer status);
}
