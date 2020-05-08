package com.atguigu.springcloud.service.imp;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: zhanxg
 * @create: 2020/5/7 21:38
 */
@Service
@Slf4j
public class OrderServiceImp implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减余额->更改状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class) //全局事务管理
    public void create(Order order) {
        log.info("---->开始新建订单");
        orderDao.create(order);

        log.info("---->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---->订单微服务开始调用库存，做扣减end");

        log.info("---->订单微服务开始调用账户，做扣减money");
        accountService.decrease(order.getId(),order.getMoney());
        log.info("---->订单微服务开始调用账户，做扣减end");

        //4.修改订单状态
        log.info("---->开始修改订单状态");
        orderDao.update(order.getId(),0);
        log.info("---->修改订单状态end");
    }
}
