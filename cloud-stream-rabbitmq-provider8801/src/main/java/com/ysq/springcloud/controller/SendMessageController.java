package com.ysq.springcloud.controller;

import com.ysq.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/01  11:32
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider messageProvider;
    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
