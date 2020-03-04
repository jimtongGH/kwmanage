package com.taianting.springboot.model;


import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:55 上午
 */
@Data
@Log
@Component
public class Shenhe implements Serializable {
    private Integer shenhe_id;
    private Integer luti_id;
    private Integer user_id;
    private String shenhe_shenhejindu;
    private String shenhe_xiugaijilu;
    private String shenhe_xiugaishuliang;
    private String shenhe_beizhu;

    public Shenhe() {
    }

    public Shenhe(Integer luti_id, Integer user_id, String shenhe_shenhejindu, String shenhe_xiugaijilu, String shenhe_xiugaishuliang, String shenhe_beizhu) {
        this.luti_id = luti_id;
        this.user_id = user_id;
        this.shenhe_shenhejindu = shenhe_shenhejindu;
        this.shenhe_xiugaijilu = shenhe_xiugaijilu;
        this.shenhe_xiugaishuliang = shenhe_xiugaishuliang;
        this.shenhe_beizhu = shenhe_beizhu;
    }
}
