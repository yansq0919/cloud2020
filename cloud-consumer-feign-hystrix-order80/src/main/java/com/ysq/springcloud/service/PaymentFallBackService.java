package com.ysq.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 功能描述
 * 对应方法的服务降级的方法体。
 * @author 闫思晴
 * @date 2022/10/17  17:44
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "服务器故障，请稍后再试！";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "服务器故障，请稍后再试！";
    }
}
