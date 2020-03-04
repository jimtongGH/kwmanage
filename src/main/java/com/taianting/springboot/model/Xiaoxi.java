package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

/**
 * @author Shengjin Tong
 * @date 2020/1/9 - 4:30 下午
 */
@Data
@Log
@Component
public class Xiaoxi {
    private Integer xiaoxi_id;
    private Integer user_id;
    private String xiaoxi_neirong;
    private String xiaoxi_shijian;
    private String xiaoxi_state;

    public Xiaoxi() {
    }

    public Xiaoxi(Integer user_id, String xiaoxi_neirong, String xiaoxi_shijian, String xiaoxi_state) {
        this.user_id = user_id;
        this.xiaoxi_neirong = xiaoxi_neirong;
        this.xiaoxi_shijian = xiaoxi_shijian;
        this.xiaoxi_state = xiaoxi_state;
    }
}
