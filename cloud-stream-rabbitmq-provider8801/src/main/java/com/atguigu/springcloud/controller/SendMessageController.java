package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send(){
        return messageProvider.send();
    }
}
