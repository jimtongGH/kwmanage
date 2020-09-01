package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:47 上午
 */
@Data
@Log
@Component
@Entity
public class Luti implements Serializable {
    @Id
    private Integer luti_id;
    private String luti_code;
    private Integer xuexiao_id;
    private Integer kemu_id;
    private String luti_shuoming;
    private String luti_jiezhishijian;

    public Luti() {
    }

    public Luti(String luti_code,
                Integer xuexiao_id,
                Integer kemu_id,
                String luti_shuoming,
                String luti_jiezhishijian) {
        this.luti_code = luti_code;
        this.xuexiao_id = xuexiao_id;
        this.kemu_id = kemu_id;
        this.luti_shuoming = luti_shuoming;
        this.luti_jiezhishijian = luti_jiezhishijian;
    }
}
