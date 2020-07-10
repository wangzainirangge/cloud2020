package com.wangzai.springcloud8004.service.impl;

import com.wangzai.springcloud8004.dao.PaymentDao;
import com.wangzai.springcloud8004.service.PaymentService;
import org.springframework.stereotype.Service;
import springcloud.entities.Payment;

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
