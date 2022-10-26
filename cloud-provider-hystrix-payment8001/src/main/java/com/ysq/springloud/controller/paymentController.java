package com.ysq.springloud.controller;

import com.ysq.springloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/11  11:13
 */
@RestController
@Slf4j
public class paymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Timeout(id);
    }


    //-----------服务熔断----------
    @GetMapping("/payment/circuit/{id}")
    public String CircuitBreaker(@PathVariable("id") Integer id){
        String s = paymentService.paymentCiruitBreaker(id);
        return s;
    }

}
