package com.atguigu.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: liuy
 * @time: 2020/7/4 11:17
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
