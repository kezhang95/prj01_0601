package com.example.distributionlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.distributionlock.mapper")
public class DistributionlockApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributionlockApplication.class, args);
    }

}
