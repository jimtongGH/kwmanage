package com.taianting.springboot;

import com.taianting.springboot.model.Jiaoshi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot的单元测试
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@SpringBootTest
class KaoshiApplicationTests {
    @Autowired
    ApplicationContext ioc;
    @Test
    public void testService() {
        boolean b = ioc.containsBean("kaowuService");
        System.out.println(b);
    }
}
