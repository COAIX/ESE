package com.lw.userservice1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.lw.userservice1.dao")
public class Userservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Userservice1Application.class, args);
    }

}
