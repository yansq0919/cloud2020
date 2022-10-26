package com.ysq.springcloud;

import com.ysq.springcloud.entities.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  22:45
 */
@SpringBootApplication  
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
