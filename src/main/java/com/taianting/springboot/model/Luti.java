package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:47 上午
 */
@Data
@Log
@Component
public class Luti implements Serializable {
    private Integer luti_id;
    private Integer pici_id;
    private Integer user_id;
    private String luti_wenjianming;
    private String luti_timushuliang;
    private String luti_jindu;
    private String luti_beizhu;

    public Luti() {
    }

    public Luti(Integer pici_id, Integer user_id, String luti_wenjianming, String luti_timushuliang, String luti_jindu, String luti_beizhu) {
        this.pici_id = pici_id;
        this.user_id = user_id;
        this.luti_wenjianming = luti_wenjianming;
        this.luti_timushuliang = luti_timushuliang;
        this.luti_jindu = luti_jindu;
        this.luti_beizhu = luti_beizhu;
    }
}
