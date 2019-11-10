package com.example.shiro.shiroexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.shiro.shiroexample.mapper")
@SpringBootApplication
public class ShiroExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroExampleApplication.class, args);
    }

}
