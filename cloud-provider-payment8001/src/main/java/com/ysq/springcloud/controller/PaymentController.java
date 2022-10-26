package com.ysq.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.ysq.springcloud.entities.CommonResult;
import com.ysq.springcloud.entities.Payment;
import com.ysq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  14:59
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功,服务端口serverport为"+port,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if (payment!=null){
            return new CommonResult(200,"查询数据库成功,查询端口为port"+port,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询id为"+id,null);
        }
    }
    @GetMapping("/payment/discovery")
    public Object discover(){
        List<String> services = discoveryClient.getServices();
        for (String ser:services){
            log.info("*****element"+ser);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance s:instances){
            log.info(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
        }
        return this.discoveryClient;
    }
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/payment/lb")
    public String getPaymentlb(){
        return port;
        }

        public String fallback(){
        return "服务器出现故障，请稍后再试！";
        }
}
