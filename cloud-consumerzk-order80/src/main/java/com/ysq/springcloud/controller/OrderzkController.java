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
 * @date 2022/09/30  16:29
 */
@RestController
@Slf4j
public class OrderzkController {
    public static  final String INVOKE_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/zk")
    public String paymentinfo(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);//远程调用
        return  result;
    }
}
