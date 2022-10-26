package com.ysq.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述     负载算法
 *设置riddon的访问服务器的规则，默认为轮询，当前设置为随机。
 * 注意：设置的新规则，不能在 @CompentScan扫描的包及其子包设置新规则，否则不能生效，
 * 设置后，在启动类添加注解 @RebbonClinet
 * @author 闫思晴
 * @date 2022/10/09  14:28
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
