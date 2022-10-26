package com.ysq.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/09/29  15:43
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced   //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
