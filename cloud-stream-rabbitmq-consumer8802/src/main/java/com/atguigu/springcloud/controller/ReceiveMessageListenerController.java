package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author: zhanxg
 * @create: 2020/5/6 11:01
 */
@Slf4j
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {


    @Value("${server.port}")
    private String serverport;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
    log.info("---------消费一号，接收消息"+message.getPayload()+"\t"+"serverport "+serverport);
    }
}
