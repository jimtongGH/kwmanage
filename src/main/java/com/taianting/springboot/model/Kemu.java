package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:38 上午
 */
@Data
@Log
@Component
public class Kemu implements Serializable {
    private Integer kemu_id;
    private String kemu_mingcheng;
    private Integer kemu_state;

    public Kemu() {
    }

    public Kemu(String kemu_mingcheng) {
        this.kemu_mingcheng = kemu_mingcheng;
    }

    public Kemu(int kemu_id,String kemu_mingcheng) {
        this.kemu_id = kemu_id;
        this.kemu_mingcheng = kemu_mingcheng;
    }
}
