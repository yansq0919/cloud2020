package com.ysq.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/09  15:18
 */
public interface LoadBalancer {
    /**
     * 获取当前访问次数的对应的服务器
     * @param serviceInstanceList ,服务器的列表（可通过disocveryClient的getinstances获取）。
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);

}
