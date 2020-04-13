package com.example.mybatisxmldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisxmldemo.mapper")
public class MybatisXmlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisXmlDemoApplication.class, args);
    }

}
