package com.ysq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/04  12:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain9002.class,args);
    }
}
