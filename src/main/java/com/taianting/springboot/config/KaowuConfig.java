package com.taianting.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 2:58 下午
 */
//指明当前类是一个配置类，用来替代之前的Spring配置文件（配Bean）
@Configuration
public class KaowuConfig {
    //@Bean将方法的返回值添加到容器中,默认id是方法名
//    @Bean
//    public KaowuService kaowuService() {
//        System.out.println("配置类@Bean给容器中添加组件");
//        return new KaowuService();
//    }
}
