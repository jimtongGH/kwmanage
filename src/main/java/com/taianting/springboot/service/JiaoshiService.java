package com.taianting.springboot.service;

import com.taianting.springboot.model.Jiaoshi;

import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2020/2/19 - 1:57 下午
 */
public interface JiaoshiService {
    List<Map<String,String>> getAllJiaoshi();
    int insertJiaoshi(Jiaoshi jiaoshi);
    int deleteSingleJiaoshi(int jiaoshi_id);
    int updateSingleJiaoshi(Jiaoshi jiaoshi);
}
