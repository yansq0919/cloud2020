package com.ysq.springcloud.controller;

import com.ysq.springcloud.entities.CommonResult;
import com.ysq.springcloud.entities.Payment;
import com.ysq.springcloud.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/10  11:35
 */
@RestController
@Slf4j
public class paymentController {
    @Resource
    private PaymentFeginService paymentFeginService;

    @GetMapping("/payment/consumer/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        CommonResult<Payment> paymentById = paymentFeginService.getPaymentById(id);
        return paymentById;
    }
    @GetMapping("/payment/comsumer/create")
    public CommonResult create(Payment payment){
        CommonResult commonResult = paymentFeginService.create(payment);
        return commonResult;
    }
}
