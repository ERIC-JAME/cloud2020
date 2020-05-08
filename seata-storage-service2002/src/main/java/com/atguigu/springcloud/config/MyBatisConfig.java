package com.atguigu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhanxg
 * @create: 2020/5/7 22:46
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.dao"}) //扫描dao的包
public class MyBatisConfig {
}
