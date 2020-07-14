package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
       /* return builder.routes().route("path_rote_atguigu", r -> r.path("guonei").uri("http://news.baidu.com/guonei")).build();*/
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_rote_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator guowai(RouteLocatorBuilder builder) {
       /* return builder.routes().route("path_rote_atguigu", r -> r.path("guonei").uri("http://news.baidu.com/guonei")).build();*/
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_rote_atguigu", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
