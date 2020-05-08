package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: zhanxg
 * @create: 2020/4/29 18:36
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
/**
 * CAP
 * C：一致性
 * A：可用性
 * P：容错性
 *
 * Eureka 设计理念是AP
 *
 */