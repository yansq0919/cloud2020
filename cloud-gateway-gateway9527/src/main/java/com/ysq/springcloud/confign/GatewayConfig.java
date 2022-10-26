package com.ysq.springcloud.confign;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/19  17:57
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_ysq",r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_ysq",r -> r.path("/photos/").uri("https://china.nba.cn/photos/")).build();
        return routes.build();
    }
}
