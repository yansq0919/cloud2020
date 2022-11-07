package com.ysq.springcloud.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/07  16:30
 */
@RestController
@RefreshScope//支持Nacos的动态刷新功能
public class NacosConfigController {
    @Value("${server.port}")
    private String port;

    @Value("${config.Info}")
    private String configInfo;

    @GetMapping("/config/Info")
    public String GetInfo(){
        return "config.Info:"+configInfo+"port:"+port;

    }
}
