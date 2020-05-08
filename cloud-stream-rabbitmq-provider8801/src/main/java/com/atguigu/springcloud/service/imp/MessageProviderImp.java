package com.atguigu.springcloud.service.imp;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author: zhanxg
 * @create: 2020/5/6 10:40
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProviderImp implements IMessageProvider {

    @Autowired
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("-------------serial:"+serial);
        return null;
    }
}
