package com.ysq.springcloud.service;

import com.ysq.springcloud.entities.CommonResult;
import com.ysq.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/10  11:29
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")       //使用Fegin,调用的已经注册在服务注册中心上的服务
public interface PaymentFeginService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping("/payment/create")
    CommonResult create(@RequestBody Payment payment);
}
