package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: zhanxg
 * @create: 2020/4/30 17:03
 */
@Configuration
public class FeignConfig {
    /**
     * feign日志级别,
     * NONE:默认的，不显示任何日志
     * BASIC：仅记录请求方法，URL，响应状态码及执行时间
     * HEADERS：除了BASIC以外，还记录请求和响应的信息
     * FULL：除了HEADERS以外，还有记录请求和响应的正文及元数据
     */
    @Bean
    Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL;
    }

}
