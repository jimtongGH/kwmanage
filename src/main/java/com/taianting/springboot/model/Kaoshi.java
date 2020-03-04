package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:24 上午
 */
@Data
@Log
@Component
public class Kaoshi implements Serializable {
    private Integer kaowu_id;
    private String kaowu_code;
    private Integer xueqi_id;
    private Integer xuexiao_id;
    private Integer kemu_id;
    private String kaowu_kaoshi;
    private String kaowu_zhuangtai;
    private String kaowu_shijian;
    private String kaowu_renshu;
    private String kaowu_kaochang;
    private String kaowu_zhuguanti;
    private String kaowu_dianzhenbi;
    private String kaowu_datizhi;
    private String kaowu_kaochangbushu;
    private String kaowu_zhishidagang;
    private String kaowu_timu;
    private String kaowu_shijuan;
    private String kaowu_kaoshengxinxi;
    private String kaowu_canyujiaoshi;
    private String kaowu_jindu;
    private String kaowu_changci;
    private String kaowu_baoming;
    private String kaowu_beizhu;
    private Integer jiaoshi_id;

    public Kaoshi() {
    }

    public Kaoshi(String kaowu_code, Integer xueqi_id, Integer xuexiao_id, Integer kemu_id, String kaowu_kaoshi, String kaowu_zhuangtai, String kaowu_shijian, String kaowu_renshu, String kaowu_kaochang, String kaowu_zhuguanti, String kaowu_dianzhenbi, String kaowu_datizhi, String kaowu_kaochangbushu, String kaowu_zhishidagang, String kaowu_timu, String kaowu_shijuan, String kaowu_kaoshengxinxi, String kaowu_canyujiaoshi, String kaowu_jindu, String kaowu_changci, String kaowu_baoming, String kaowu_beizhu, Integer jiaoshi_id) {
        this.kaowu_code = kaowu_code;
        this.xueqi_id = xueqi_id;
        this.xuexiao_id = xuexiao_id;
        this.kemu_id = kemu_id;
        this.kaowu_kaoshi = kaowu_kaoshi;
        this.kaowu_zhuangtai = kaowu_zhuangtai;
        this.kaowu_shijian = kaowu_shijian;
        this.kaowu_renshu = kaowu_renshu;
        this.kaowu_kaochang = kaowu_kaochang;
        this.kaowu_zhuguanti = kaowu_zhuguanti;
        this.kaowu_dianzhenbi = kaowu_dianzhenbi;
        this.kaowu_datizhi = kaowu_datizhi;
        this.kaowu_kaochangbushu = kaowu_kaochangbushu;
        this.kaowu_zhishidagang = kaowu_zhishidagang;
        this.kaowu_timu = kaowu_timu;
        this.kaowu_shijuan = kaowu_shijuan;
        this.kaowu_kaoshengxinxi = kaowu_kaoshengxinxi;
        this.kaowu_canyujiaoshi = kaowu_canyujiaoshi;
        this.kaowu_jindu = kaowu_jindu;
        this.kaowu_changci = kaowu_changci;
        this.kaowu_baoming = kaowu_baoming;
        this.kaowu_beizhu = kaowu_beizhu;
        this.jiaoshi_id = jiaoshi_id;
    }
}
