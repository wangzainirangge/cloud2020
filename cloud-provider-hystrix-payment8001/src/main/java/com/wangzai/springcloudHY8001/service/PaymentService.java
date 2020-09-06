package com.wangzai.springcloudHY8001.service;

import springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

    public String paymentFeignTimeout();

    public String getPaymentByIdBreaker(Long id);
}
