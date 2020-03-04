package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:51 上午
 */
@Data
@Log
@Component
public class Pici implements Serializable {
    private  Integer pici_id;
    private Integer xuexiao_id;
    private Integer kemu_id;
    private Integer jiaoshi_id;
    private String pici_lutipihao;
    private String pici_wenjianshuliang;
    private String pici_lutishuoming;
    private String pici_kaishishijian;
    private String pici_jiezhishijian;
    private String pici_zhuangtai;
    private String pici_beizhu;

    public Pici() {
    }

    public Pici(Integer xuexiao_id, Integer kemu_id, Integer jiaoshi_id, String pici_lutipihao, String pici_wenjianshuliang, String pici_lutishuoming, String pici_kaishishijian, String pici_jiezhishijian, String pici_zhuangtai, String pici_beizhu) {
        this.xuexiao_id = xuexiao_id;
        this.kemu_id = kemu_id;
        this.jiaoshi_id = jiaoshi_id;
        this.pici_lutipihao = pici_lutipihao;
        this.pici_wenjianshuliang = pici_wenjianshuliang;
        this.pici_lutishuoming = pici_lutishuoming;
        this.pici_kaishishijian = pici_kaishishijian;
        this.pici_jiezhishijian = pici_jiezhishijian;
        this.pici_zhuangtai = pici_zhuangtai;
        this.pici_beizhu = pici_beizhu;
    }
}
