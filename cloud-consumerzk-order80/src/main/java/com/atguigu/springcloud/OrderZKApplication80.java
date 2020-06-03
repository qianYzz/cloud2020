package com.atguigu.springcloud;

/**
 * @description:
 * @author: liuy
 * @time: 2020/6/3 9:18
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKApplication80.class, args);
    }
}


