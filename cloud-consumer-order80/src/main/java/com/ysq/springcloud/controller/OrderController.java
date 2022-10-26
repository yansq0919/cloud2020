package com.ysq.springcloud.controller;

import com.ysq.springcloud.lib.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.ysq.springcloud.entities.CommonResult;
import com.ysq.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.junit.runners.Parameterized;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  15:40
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="HTTP://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;      //自己写的负载均衡算法


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("开始新增{}",payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("开始查找{},id为",id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

    }

    /**
     * restTemplate的getForEntity的使用。
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getpayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info(forEntity.getStatusCode()+"\t"+forEntity.getHeaders());
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

    /**
     * restTemplate的postForEntity
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/postForeEntity")
    public CommonResult<Payment> create2(Payment payment){
        log.info("开始新增{}",payment);
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful()){
            return commonResultResponseEntity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }
    @PostMapping("/test")
    public String test(int id){
        System.out.println(id);
        return "ok";
    }

    /**
     * 轮询算法测试
     * @return
     */
    @GetMapping("/consumer/payment/lb")
    public String getpaymentlb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");//获取该项目中的服务器的集合
        //判断服务器是否存在
        if (instances==null || instances.size()<=0){
            return null;
        }
        ServiceInstance instances1 = loadBalancer.instances(instances);//获取对应下标的服务器实例.当前ip的服务器，例：http://192.168.209.1:8001
        URI uri = instances1.getUri();//获取服务器的uri:(http://192.168.209.1:8001)
        System.out.println(uri);
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
