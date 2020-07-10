package com.wangzai.springcloud8001.service.impl;

import com.wangzai.springcloud8001.dao.PaymentDao;
import springcloud.entities.Payment;
import com.wangzai.springcloud8001.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
