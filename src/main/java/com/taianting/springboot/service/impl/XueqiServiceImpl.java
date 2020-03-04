package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.XueqiMapper;
import com.taianting.springboot.model.Xueqi;
import com.taianting.springboot.service.XueqiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class XueqiServiceImpl implements XueqiService {
    @Autowired
    XueqiMapper xueqiMapper;

    @Override
    public List<Map<String, String>> getAllXueqi() {
        return xueqiMapper.getAllXueqi();
    }

    @Override
    public int insertXueqi(Xueqi xueqi) {
        return xueqiMapper.insertXueqi(xueqi);
    }

    @Override
    public int deleteSingleXueqi(int xueqi_id) {
        return xueqiMapper.deleteSingleXueqi(xueqi_id);
    }

    @Override
    public int updateSingleXueqi(Xueqi xueqi) {
        return xueqiMapper.updateSingleXueqi(xueqi);
    }
}
