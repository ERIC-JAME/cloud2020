package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/6 16:59
 */
@RestController
@RefreshScope //动态刷新
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/config/info",method = RequestMethod.GET)
    public String getConfigInfo(){
        return serverPort;
    }
}
