package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: zhanxg
 * @create: 2020/4/30 12:30
 */
public interface LoadBalance {

    //服务实例
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
