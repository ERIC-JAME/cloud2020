package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/3 12:49
 */
@RestController
@RefreshScope //带有刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping(value = "/configInfo",method = RequestMethod.GET)
    public String getConfigInfo(){
        return configInfo;
    }
}
