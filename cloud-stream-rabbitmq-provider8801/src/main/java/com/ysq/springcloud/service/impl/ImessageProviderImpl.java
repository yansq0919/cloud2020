package com.ysq.springcloud.service.impl;
import com.ysq.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/01  11:26
 */
@EnableBinding(Source.class)
@Slf4j
public class ImessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*****serial: {}", serial);
        return serial;
    }
}
