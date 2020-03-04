package com.taianting.springboot.service;

import com.taianting.springboot.model.Kemu;

import java.util.List;
import java.util.Map;

public interface KemuService {
    List<Map<String ,String>> getAllKemu();
    int insertKemu(Kemu kemu);
    int deleteSingleKemu(int kemu_id);
    int updateSingleKemu(Kemu kemu);
}
