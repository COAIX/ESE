package com.lw.patientservice1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.lw.patientservice1.dao")
public class Patientservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Patientservice1Application.class, args);
    }

}
