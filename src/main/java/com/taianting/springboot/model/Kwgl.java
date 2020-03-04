package com.taianting.springboot.model;


import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:41 上午
 */
@Data
@Log
@Component
//考务管理
public class Kwgl implements Serializable {
    private Integer ID;
    private String CODE;
    private String XUEQI;
    private String XUEXIAO;
    private String KEMU;
    private String FUZEJIAOSHI;
    private String KAOSHI;
    private String ZHUANGTAI;
    private String SHIJIAN;
    private String RENSHU;
    private String KAOCHANG;
    private String ZHUGUANTI;
    private String DIANZHENBI;
    private String DATIZHI;
    private String KAOCHANGBUSHU;
    private String ZHISHIDAGANG;
    private String TIMU;
    private String SHIJUAN;
    private String KAOSHENGXINXI;
    private String CANYUJIAOSHI;
    private String JINDU;
    private String BEIZHU;
    private String CHANGCI;
    private String BAOMING;

    public Kwgl() {
    }

    public Kwgl(String CODE, String XUEQI, String XUEXIAO, String KEMU, String FUZEJIAOSHI, String KAOSHI, String ZHUANGTAI, String SHIJIAN, String RENSHU, String KAOCHANG, String ZHUGUANTI, String DIANZHENBI, String DATIZHI, String KAOCHANGBUSHU, String ZHISHIDAGANG, String TIMU, String SHIJUAN, String KAOSHENGXINXI, String CANYUJIAOSHI, String JINDU, String BEIZHU, String CHANGCI, String BAOMING) {
        this.CODE = CODE;
        this.XUEQI = XUEQI;
        this.XUEXIAO = XUEXIAO;
        this.KEMU = KEMU;
        this.FUZEJIAOSHI = FUZEJIAOSHI;
        this.KAOSHI = KAOSHI;
        this.ZHUANGTAI = ZHUANGTAI;
        this.SHIJIAN = SHIJIAN;
        this.RENSHU = RENSHU;
        this.KAOCHANG = KAOCHANG;
        this.ZHUGUANTI = ZHUGUANTI;
        this.DIANZHENBI = DIANZHENBI;
        this.DATIZHI = DATIZHI;
        this.KAOCHANGBUSHU = KAOCHANGBUSHU;
        this.ZHISHIDAGANG = ZHISHIDAGANG;
        this.TIMU = TIMU;
        this.SHIJUAN = SHIJUAN;
        this.KAOSHENGXINXI = KAOSHENGXINXI;
        this.CANYUJIAOSHI = CANYUJIAOSHI;
        this.JINDU = JINDU;
        this.BEIZHU = BEIZHU;
        this.CHANGCI = CHANGCI;
        this.BAOMING = BAOMING;
    }
}
