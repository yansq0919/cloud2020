package com.ysq.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/04  17:14
 */
@RestController
@Slf4j
public class NacosOrderController {
    @Value("${service-url.nacos-user-service}")
    private String Url;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public String getIno(@PathVariable("id") String id){
        return restTemplate.getForObject(Url+"/get/"+id,String.class);
    }
}
