package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @GetMapping("index")
    public String index(){
        return "helo";
    }
    @Resource
    private OrderService orderService;
    @PostMapping("order/add")
    public CommonResult addOrder(@RequestBody Order order){
        orderService.create(order);
        return new CommonResult(0,"订单添加成功");
    }
}
