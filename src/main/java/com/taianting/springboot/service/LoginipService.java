package com.taianting.springboot.service;

import com.taianting.springboot.model.Loginip;

import java.util.List;
import java.util.Map;

public interface LoginipService {
    int insertLoginip(Loginip loginip);
    List<Map<String, String>> getAllLoginipByUserId(String user_id);
}
