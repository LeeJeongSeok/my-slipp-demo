package com.lee.practice.myslippdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MySlippDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySlippDemoApplication.class, args);
    }

}
