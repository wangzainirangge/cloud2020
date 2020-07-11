package com.wangzai.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping(value = "/payment")
public interface PaymentFeignService {

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout();

}
