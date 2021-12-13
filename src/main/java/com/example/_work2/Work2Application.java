package com.example._work2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example._work2.mapper")
public class Work2Application {

    public static void main(String[] args) {
        SpringApplication.run(Work2Application.class, args);
    }

}
