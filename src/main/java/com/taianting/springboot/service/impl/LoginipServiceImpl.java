package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.LoginipMapper;
import com.taianting.springboot.model.Loginip;
import com.taianting.springboot.service.LoginipService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class LoginipServiceImpl implements LoginipService {
    @Autowired
    LoginipMapper loginipMapper;

    @Override
    public int insertLoginip(Loginip loginip) {
        return loginipMapper.insertLoginip(loginip);
    }

    @Override
    public List<Map<String, String>> getAllLoginipByUserId(String user_id) {
        return loginipMapper.getAllLoginipByUserId(user_id);
    }
}
