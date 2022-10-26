package com.ysq.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/08  15:55
 */
@RestController
@Slf4j
public class OrderContoller{
    public static final String INVOKE_URL="http://consul-provider-payment";//服务提供者的地址

    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/consul")
    public String payment(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
 }
