package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info(payment.toString());
        //写操作
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/create2")
    public CommonResult<Payment> create2(Payment payment) {
        log.info(payment.toString());
        //写操作
        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

        log.info(resultResponseEntity.toString());

        return resultResponseEntity.getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        log.info(resultResponseEntity.toString());

        return resultResponseEntity.getBody();
    }


    /*
     * 使用自己的负载均衡方法测试
     * */
    @GetMapping("/consumer/payment/getLb")
    public String getPaymentLb() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalancer.instances(instanceList);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/getLb",String.class);
    }
}
