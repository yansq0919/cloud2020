package com.ysq.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/04  11:49
 */
@RestController
@Slf4j
public class NacosConsumer {
    @Value("${server.port}")
    private String serverport;

    @GetMapping("/get/{id}")
    public String Getport(@PathVariable String id){
        return "serverport:"+serverport+"\tid"+id;
    }
}
