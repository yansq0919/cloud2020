package com.ysq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/04  17:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain83.class,args);
    }
}
