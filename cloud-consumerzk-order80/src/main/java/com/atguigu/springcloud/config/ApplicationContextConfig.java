package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhanxg
 * @create: 2020/4/30 9:27
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
    @LoadBalanced
    public RestTemplate getRestemplate(){
        return new RestTemplate();
    }
}
