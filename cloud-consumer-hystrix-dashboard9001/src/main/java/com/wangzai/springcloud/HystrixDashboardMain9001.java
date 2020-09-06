package com.wangzai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    //http://localhost:9001/hystrix         访问路径
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }

}
