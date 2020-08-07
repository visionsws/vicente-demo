package com.vicente.vicentedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vicente.vicentedemo.mapper")
public class VicenteDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VicenteDemoApplication.class, args);
    }

}
