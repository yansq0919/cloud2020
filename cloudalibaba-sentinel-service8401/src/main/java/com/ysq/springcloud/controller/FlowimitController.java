package com.ysq.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/11/08  16:43
 */
@RestController
public class FlowimitController {
    @GetMapping("/test1")
    public String test1(){
        return "----------test1";
    }
    @GetMapping("/test2")
    public String test2(){
        return "----------test2";
    }
}
