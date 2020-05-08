package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhanxg
 * @create 2020/4/29 15:46
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 需要三个参数
     * 1.url:请求路径
     * 2.requestMap：请求的参数
     * 3.object.class：对象
     * @return
     */
    @Bean
   // @LoadBalanced//使用负载均衡。默认轮询的机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
