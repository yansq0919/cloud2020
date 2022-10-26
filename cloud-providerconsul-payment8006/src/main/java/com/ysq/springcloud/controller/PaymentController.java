package com.ysq.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 功能描述
 *  将服务注册进consul
 * @author 闫思晴
 * @date 2022/10/08  15:42
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverport;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul"+serverport+"\t"+ UUID.randomUUID().toString();
    }
}
