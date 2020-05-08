package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/6 9:00
 */
@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    //config.info github上的info信息
    @Value("${config.info}")
    private String configInfo;

    @RequestMapping(value = "/configInfo",method = RequestMethod.GET)
    public String configInfo(){
        return "serverPort"+serverPort+"\t"+"configInfo"+configInfo;
    }
}
