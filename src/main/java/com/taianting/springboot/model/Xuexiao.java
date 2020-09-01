package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 12:01 下午
 */
@Data
@Log
@Component
@Entity
public class Xuexiao implements Serializable {
    @Id
    private Integer xuexiao_id;
    private String xuexiao_mingcheng;
    private Integer xuexiao_state;

    public Xuexiao() {
    }

    public Xuexiao(String xuexiao_mingcheng) {
        this.xuexiao_mingcheng = xuexiao_mingcheng;
    }

    public Xuexiao(int xuexiao_id,
                   String xuexiao_mingcheng) {
        this.xuexiao_id = xuexiao_id;
        this.xuexiao_mingcheng = xuexiao_mingcheng;
    }
}
