package com.ysq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  16:40
 */
@SpringBootApplication
@EnableEurekaServer     //服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
