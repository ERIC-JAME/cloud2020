package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhanxg
 * @create: 2020/5/6 15:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain83 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain83.class,args);
    }
}
