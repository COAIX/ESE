package com.lw.appointmentservice1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.lw.appointmentservice1.dao")
public class Appointmentservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Appointmentservice1Application.class, args);
    }

}
