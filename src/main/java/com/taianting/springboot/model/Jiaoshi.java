package com.taianting.springboot.model;


import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author Shengjin Tong
 * @date 2019/12/26 - 4:41 下午
 */
@Data
@Log
//将类加载在容器中
@Component
//获取yml配置文件中的相关配置进行绑定，绑定后编写配置会有提示
//@ConfigurationProperties(prefix = "jiaoshi")
@Entity
public class Jiaoshi implements Serializable {
    /**
     * 俗称的配bean：
     * <bean class="Jiaoshi">
     *     <property name="xxx" value="?/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * </bean>
     * value值就是注解value中要填写的东西
     * @ Value
     */
    @Id
    private Integer jiaoshi_id;
    private String jiaoshi_xingming;
    private String jiaoshi_shoujihaoma;
    private Integer xuexiao_id;
    private Integer jiaoshi_state;

    public Jiaoshi() {
    }

    public Jiaoshi(String jiaoshi_xingming,
                   String jiaoshi_shoujihaoma,
                   Integer xuexiao_id) {
        this.jiaoshi_xingming = jiaoshi_xingming;
        this.jiaoshi_shoujihaoma = jiaoshi_shoujihaoma;
        this.xuexiao_id = xuexiao_id;
    }

    public Jiaoshi(int jiaoshi_id,
                   Integer xuexiao_id,
                   String jiaoshi_xingming,
                   String jiaoshi_shoujihaoma) {
        this.jiaoshi_id = jiaoshi_id;
        this.xuexiao_id = xuexiao_id;
        this.jiaoshi_xingming = jiaoshi_xingming;
        this.jiaoshi_shoujihaoma = jiaoshi_shoujihaoma;
    }
}
