package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zhanxg
 * @create: 2020/5/7 14:57
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //激活feign
public class ConsumerNacosMain84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosMain84.class,args);
    }
}
