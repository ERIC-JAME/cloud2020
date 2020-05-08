package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhanxg
 * @create: 2020/5/6 10:50
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @RequestMapping(value = "/sendMessage",method = RequestMethod.GET)
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
