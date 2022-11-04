package com.ysq.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/04  12:10
 */
@RestController
public class NacosController9002 {
    @Value("${server.port}")
    private String serverport;

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id){
        return "serverport:"+serverport+"id:"+id;
    }
}
