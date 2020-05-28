package com.xiangyang.application;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.xiangyang.mapper")
@ComponentScan(basePackages = {"com.xiangyang.model","com.xiangyang.service",
        "com.xiangyang.config","com.xiangyang.controller","com.xiangyang.esearch"})
@EnableApolloConfig
//@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
