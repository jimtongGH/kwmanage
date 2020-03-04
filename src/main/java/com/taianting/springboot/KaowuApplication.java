package com.taianting.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
//@ComponentScan(basePackages = {"com.taianting.springboot.mapper","com.taianting.springboot.config","com.taianting.springboot.service.impl","com.taianting.springboot.service","com.taianting.springboot.model","com.taianting.springboot.controller"})
@MapperScan(basePackages = {"com.taianting.springboot.mapper"} ,sqlSessionFactoryRef = "sqlSessionFactory")
public class KaowuApplication {
    public static void main(String[] args) {
        SpringApplication.run(KaowuApplication.class, args);
    }
}
