package com.ysq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/18  16:27
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystriDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystriDashboardMain9001.class,args);
    }
}
