package com.lw.g_healthcare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lw.g_healthcare.dao")
public class GHealthcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GHealthcareApplication.class, args);
    }

}
