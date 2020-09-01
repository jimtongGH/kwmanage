package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 11:24 上午
 */
@Data
@Log
@Component
@Entity
public class Kaoshi implements Serializable {
    @Id
    private Integer kaoshi_id;
    private String kaoshi_code;
    private Integer xueqi_id;
    private Integer xuexiao_id;
    private Integer kemu_id;
    private Integer jiaoshi_id;
    private String kaoshi_mingcheng;
    private String kaoshi_shijian;
    private String kaoshi_canyujiaoshi;
    private String kaoshi_xueshengmingdan;
    private String kaoshi_renshu;
    private String kaoshi_timu;
    private String kaoshi_shijuan;
    private String kaoshi_dianzhenbi;
    private String kaoshi_dianzhenzhi;
    private String kaoshi_baoming;
    private String kaoshi_kaochangzhunbei;
    private String kaoshi_changci;
    private String kaoshi_shezhi;
    private String kaoshi_leixing;
    private String kaoshi_beizhu;
    private String kaoshi_tixing;
    //状态
    //（灰色）未开始0、已取消-10、已终止-20
    //（绿色）筹备中10、正在报名20、已发布30
    //（红色）正在考试100、阅卷中110、成绩发布120
    //（黑色）已完成200
    private Integer kaoshi_zhuangtai;
    private Integer kaoshi_state;
    private String kaoshi_chuangjianren;
    private String kaoshi_chuangjianshijian;
    private String kaoshi_xiugairen;
    private String kaoshi_xiugaishijian;

    public Kaoshi() {
    }

    //新增
    public Kaoshi(String kaoshi_code,
                  Integer xueqi_id,
                  Integer xuexiao_id,
                  Integer kemu_id,
                  Integer jiaoshi_id,
                  String kaoshi_mingcheng,
                  String kaoshi_shijian,
                  String kaoshi_canyujiaoshi,
                  String kaoshi_xueshengmingdan,
                  String kaoshi_renshu,
                  String kaoshi_timu,
                  String kaoshi_shijuan,
                  String kaoshi_dianzhenbi,
                  String kaoshi_dianzhenzhi,
                  String kaoshi_baoming,
                  String kaoshi_kaochangzhunbei,
                  String kaoshi_changci,
                  String kaoshi_shezhi,
                  String kaoshi_leixing,
                  String kaoshi_beizhu,
                  String kaoshi_tixing,
                  Integer kaoshi_zhuangtai,
                  String kaoshi_chuangjianren,
                  String kaoshi_chuangjianshijian) {
        this.kaoshi_code = kaoshi_code;
        this.xueqi_id = xueqi_id;
        this.xuexiao_id = xuexiao_id;
        this.kemu_id = kemu_id;
        this.jiaoshi_id = jiaoshi_id;
        this.kaoshi_mingcheng = kaoshi_mingcheng;
        this.kaoshi_shijian = kaoshi_shijian;
        this.kaoshi_canyujiaoshi = kaoshi_canyujiaoshi;
        this.kaoshi_xueshengmingdan = kaoshi_xueshengmingdan;
        this.kaoshi_renshu = kaoshi_renshu;
        this.kaoshi_timu = kaoshi_timu;
        this.kaoshi_shijuan = kaoshi_shijuan;
        this.kaoshi_dianzhenbi = kaoshi_dianzhenbi;
        this.kaoshi_dianzhenzhi = kaoshi_dianzhenzhi;
        this.kaoshi_baoming = kaoshi_baoming;
        this.kaoshi_kaochangzhunbei = kaoshi_kaochangzhunbei;
        this.kaoshi_changci = kaoshi_changci;
        this.kaoshi_shezhi = kaoshi_shezhi;
        this.kaoshi_leixing = kaoshi_leixing;
        this.kaoshi_beizhu = kaoshi_beizhu;
        this.kaoshi_tixing = kaoshi_tixing;
        this.kaoshi_zhuangtai = kaoshi_zhuangtai;
        this.kaoshi_chuangjianren = kaoshi_chuangjianren;
        this.kaoshi_chuangjianshijian = kaoshi_chuangjianshijian;
    }

    //修改
    public Kaoshi(Integer kaoshi_id,
                  String kaoshi_code,
                  Integer xueqi_id,
                  Integer xuexiao_id,
                  Integer kemu_id,
                  Integer jiaoshi_id,
                  String kaoshi_mingcheng,
                  String kaoshi_shijian,
                  String kaoshi_canyujiaoshi,
                  String kaoshi_xueshengmingdan,
                  String kaoshi_renshu,
                  String kaoshi_timu,
                  String kaoshi_shijuan,
                  String kaoshi_dianzhenbi,
                  String kaoshi_dianzhenzhi,
                  String kaoshi_baoming,
                  String kaoshi_kaochangzhunbei,
                  String kaoshi_changci,
                  String kaoshi_shezhi,
                  String kaoshi_leixing,
                  String kaoshi_beizhu,
                  String kaoshi_tixing,
                  Integer kaoshi_zhuangtai,
                  String kaoshi_xiugairen,
                  String kaoshi_xiugaishijian) {
        this.kaoshi_id = kaoshi_id;
        this.kaoshi_code = kaoshi_code;
        this.xueqi_id = xueqi_id;
        this.xuexiao_id = xuexiao_id;
        this.kemu_id = kemu_id;
        this.jiaoshi_id = jiaoshi_id;
        this.kaoshi_mingcheng = kaoshi_mingcheng;
        this.kaoshi_shijian = kaoshi_shijian;
        this.kaoshi_canyujiaoshi = kaoshi_canyujiaoshi;
        this.kaoshi_xueshengmingdan = kaoshi_xueshengmingdan;
        this.kaoshi_renshu = kaoshi_renshu;
        this.kaoshi_timu = kaoshi_timu;
        this.kaoshi_shijuan = kaoshi_shijuan;
        this.kaoshi_dianzhenbi = kaoshi_dianzhenbi;
        this.kaoshi_dianzhenzhi = kaoshi_dianzhenzhi;
        this.kaoshi_baoming = kaoshi_baoming;
        this.kaoshi_kaochangzhunbei = kaoshi_kaochangzhunbei;
        this.kaoshi_changci = kaoshi_changci;
        this.kaoshi_shezhi = kaoshi_shezhi;
        this.kaoshi_leixing = kaoshi_leixing;
        this.kaoshi_beizhu = kaoshi_beizhu;
        this.kaoshi_tixing = kaoshi_tixing;
        this.kaoshi_zhuangtai = kaoshi_zhuangtai;
        this.kaoshi_xiugairen = kaoshi_xiugairen;
        this.kaoshi_xiugaishijian = kaoshi_xiugaishijian;
    }
}
