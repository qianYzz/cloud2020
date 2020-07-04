package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: liuy
 * @time: 2020/6/23 14:06
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulApplication.class, args);
    }
}
