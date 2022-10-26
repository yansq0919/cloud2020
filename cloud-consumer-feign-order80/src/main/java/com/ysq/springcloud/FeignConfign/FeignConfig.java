package com.ysq.springcloud.FeignConfign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 功能描述
 *设置feign的日志
 * @author 闫思晴
 * @date 2022/10/10  16:36
 */
@Configuration
public class FeignConfig {

        @Bean
        Logger.Level feignLoggerLevel(){
            return Logger.Level.FULL;
    }
}
