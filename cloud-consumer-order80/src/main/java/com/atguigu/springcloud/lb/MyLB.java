package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhanxg
 * @create: 2020/4/30 12:35
 */
@Component
@Slf4j
public class MyLB implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁
        do {
            current = this.atomicInteger.get();
            next = current>=2147483647 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        log.info("-------next"+next);
        return next;
    }

   @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

       int index = getAndIncrement() % serviceInstances.size();
       return serviceInstances.get(index);
    }
}
