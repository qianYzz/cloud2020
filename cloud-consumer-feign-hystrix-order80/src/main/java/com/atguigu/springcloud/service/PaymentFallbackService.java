package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: liuy
 * @time: 2020/7/11 11:09
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentFallBack=======paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentFallBack=======paymentInfo_TimeOut";
    }
}
