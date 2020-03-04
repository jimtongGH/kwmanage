package com.taianting.springboot.service;

import com.taianting.springboot.model.Xueqi;

import java.util.List;
import java.util.Map;

public interface XueqiService {
    List<Map<String ,String>> getAllXueqi();
    int insertXueqi(Xueqi xueqi);
    int deleteSingleXueqi(int xueqi_id);
    int updateSingleXueqi(Xueqi xueqi);
}
