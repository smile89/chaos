package com.chaos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.chaos.mapper")
@EnableScheduling
public class ChaosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaosApplication.class, args);
    }

}
