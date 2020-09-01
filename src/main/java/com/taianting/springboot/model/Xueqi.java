package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 20Log12/27 - 12:00 下午
 */
@Data
@Log
@Component
@Entity
public class Xueqi implements Serializable {
    @Id
    private Integer xueqi_id;
    private String xueqi_mingcheng;
    private Integer xueqi_state;

    public Xueqi() {
    }

    public Xueqi(String xueqi_mingcheng) {
        this.xueqi_mingcheng = xueqi_mingcheng;
    }

    public Xueqi(int xueqi_id,
                 String xueqi_mingcheng) {
        this.xueqi_id = xueqi_id;
        this.xueqi_mingcheng = xueqi_mingcheng;
    }
}
