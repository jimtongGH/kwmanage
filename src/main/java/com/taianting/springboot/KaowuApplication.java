package com.taianting.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(value = {"com.taianting.springboot"})
//@EnableAutoConfiguration
@MapperScan(basePackages = {"com.taianting.springboot.mapper"} ,sqlSessionFactoryRef = "sqlSessionFactory")
public class KaowuApplication {
    public static void main(String[] args) {
        SpringApplication.run(KaowuApplication.class, args);
    }
}
