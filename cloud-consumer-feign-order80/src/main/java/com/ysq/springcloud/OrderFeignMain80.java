package com.ysq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/10  11:28
 */
@SpringBootApplication
@EnableFeignClients          //开启Feign（服务调用）
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
