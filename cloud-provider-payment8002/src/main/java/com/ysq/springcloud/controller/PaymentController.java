package com.ysq.springcloud.controller;

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
 * @date 2022/09/29  22:38
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverport;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*******插入结果:"+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功,serverport:"+serverport,result);
        }else{
            return new CommonResult(444,"插入失败");
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询的数据为"+paymentById);
        if (paymentById!=null){
            return new CommonResult(200,"查询成功,serverport:"+serverport,paymentById);
        }else{
            return new CommonResult(444,"查询失败"+id,null);
        }
    }

//    @GetMapping("/payment/discovery")
//    public Object discover(){
//        List<String> services = discoveryClient.getServices();
//        for (String ser:services){
//            log.info("*****element"+ser);
//        }
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        for (ServiceInstance s:instances){
//            log.info(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
//        }
//        return this.discoveryClient;
//    }

    /**
     * 获取端口
     *
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentlb(){
        return serverport;
    }
}
