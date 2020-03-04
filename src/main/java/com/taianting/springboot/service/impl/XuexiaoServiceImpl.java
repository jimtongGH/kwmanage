package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.XuexiaoMapper;
import com.taianting.springboot.model.Xuexiao;
import com.taianting.springboot.service.XuexiaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class XuexiaoServiceImpl implements XuexiaoService {
    @Autowired
    XuexiaoMapper xuexiaoMapper;

    @Override
    public List<Map<String, String>> getAllXuexiao() {
        return xuexiaoMapper.getAllXuexiao();
    }

    @Override
    public int insertXuexiao(Xuexiao xuexiao) {
        return xuexiaoMapper.insertXuexiao(xuexiao);
    }

    @Override
    public int deleteSingleXuexiao(int xuexiao_id) {
        return xuexiaoMapper.deleteSingleXuexiao(xuexiao_id);
    }

    @Override
    public int updateSingleXuexiao(Xuexiao xuexiao) {
        return xuexiaoMapper.updateSingleXuexiao(xuexiao);
    }
}
