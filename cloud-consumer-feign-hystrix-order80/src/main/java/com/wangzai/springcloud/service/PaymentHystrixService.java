package com.wangzai.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallbackService.class)
//当PaymentHystrixService被fallback类实现时不能使用@RequestMapping注解！
//@RequestMapping(value = "/payment")
public interface PaymentHystrixService {

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
