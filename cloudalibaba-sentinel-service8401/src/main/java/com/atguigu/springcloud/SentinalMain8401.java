package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: zhanxg
 * @create: 2020/5/6 19:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinalMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinalMain8401.class,args);
    }
}
