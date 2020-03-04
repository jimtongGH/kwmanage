package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.KaoshiMapper;
import com.taianting.springboot.service.KaoshiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class KaoshiServiceImpl implements KaoshiService {
    @Autowired
    KaoshiMapper kaoshiMapper;

    public List<Map<String, String>> getAllKaowuByXueqiId(int xueqi_id) {
        return kaoshiMapper.getAllKaowuByXueqiId(xueqi_id);
    }
}
