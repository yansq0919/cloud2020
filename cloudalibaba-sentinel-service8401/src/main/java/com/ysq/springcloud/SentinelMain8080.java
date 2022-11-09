package com.ysq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/08  16:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8080.class,args);
    }
}
