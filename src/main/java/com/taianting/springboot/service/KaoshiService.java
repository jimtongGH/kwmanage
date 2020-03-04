package com.taianting.springboot.service;

import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 3:03 下午
 */
public interface KaoshiService {
    List<Map<String, String>> getAllKaowuByXueqiId(int xueqi_id);
}
