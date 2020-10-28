package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: liuy
 * @time: 2020/8/8 15:12
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName());
        return "------testB";
    }


    @GetMapping("/testD")
    public String testD() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int i = 10 / 0;
        log.info("testD 测试异常比例");

        return "------testD";
    }

    @GetMapping("/testE")
    @SentinelResource(value = "testE", blockHandler = "handlerTestE")
    public String testE(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2) {
        //int age = 10 / 0;
        return "----------testE";
    }

    public String handlerTestE(String p1, String p2, BlockException blcok) {
        log.info(p1, p2);
        return "----热点数据限流";
    }
}
