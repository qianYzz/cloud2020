package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: liuy
 * @time: 2020/5/22 17:15
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
