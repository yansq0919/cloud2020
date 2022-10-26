package com.ysq.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ysq.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/11  15:04
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")       //设置fallback的方法，全局的方法
public class OrderController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_ok(id);
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})//设置红线，当相应时间超过1500时，执行paymentInfo_TimeoutHandler方法
      //当出异常时，调用paymentInfo_TimeoutHandler方法来兜底
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        int i=10/0;
        return paymentHystrixService.paymentInfo_timeout(id);
    }

    /**
     * 当出现异常或者访问超时后执行的方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandler(Integer id){
        return "消费者80，对方支付系统繁忙，请10秒钟后再试或者检查自己运行出错请检查自己，nonono";
    }
    //通用fallback的方法，全局方法
    public String payment_Global_FallBackMethod(){
        return "服务器故障，请稍后再试！";
    }
}
