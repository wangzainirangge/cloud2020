package com.wangzai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//该注解向使用consul或者zookeeper作为注册中心时注册服务f
@EnableDiscoveryClient
public class OrderMainZK80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainZK80.class,args);
    }

}
