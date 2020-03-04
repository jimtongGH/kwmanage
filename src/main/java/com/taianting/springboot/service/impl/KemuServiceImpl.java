package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.KemuMapper;
import com.taianting.springboot.model.Kemu;
import com.taianting.springboot.service.KemuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class KemuServiceImpl implements KemuService {
    @Autowired
    KemuMapper kemuMapper;

    @Override
    public List<Map<String, String>> getAllKemu() {
        return kemuMapper.getAllKemu();
    }

    @Override
    public int insertKemu(Kemu kemu) {
        return kemuMapper.insertKemu(kemu);
    }

    @Override
    public int deleteSingleKemu(int kemu_id) {
        return kemuMapper.deleteSingleKemu(kemu_id);
    }

    @Override
    public int updateSingleKemu(Kemu kemu) {
        return kemuMapper.updateSingleKemu(kemu);
    }
}
