package com.taianting.springboot.service;

import com.taianting.springboot.model.Xuexiao;

import java.util.List;
import java.util.Map;

public interface XuexiaoService {
    List<Map<String ,String>> getAllXuexiao();
    int insertXuexiao(Xuexiao xuexiao);
    int deleteSingleXuexiao(int xuexiao_id);
    int updateSingleXuexiao(Xuexiao xuexiao);
}
