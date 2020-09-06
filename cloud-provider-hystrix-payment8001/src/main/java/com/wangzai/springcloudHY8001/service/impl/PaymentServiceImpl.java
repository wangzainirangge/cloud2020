package com.wangzai.springcloudHY8001.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangzai.springcloudHY8001.dao.PaymentDao;
import com.wangzai.springcloudHY8001.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import springcloud.entities.Payment;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    //*******服务降级*******

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @HystrixCommand(fallbackMethod = "paymentFeignTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public String paymentFeignTimeout() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return serverPort;
    }

    public String paymentFeignTimeoutHandler(){
        return "服务降级服务端";
    }

    //*******服务熔断*******

    @HystrixCommand(fallbackMethod = "paymentFeignBreakerHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少跳闸  10次有6次
    })
    @Override
    public String getPaymentByIdBreaker(Long id) {
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        return paymentDao.getPaymentById(id).toString();
    }

    public String paymentFeignBreakerHandler(Long id){
        return "id不能为负数，服务熔断";
    }

}
