package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.JiaoshiMapper;
import com.taianting.springboot.model.Jiaoshi;
import com.taianting.springboot.service.JiaoshiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2020/2/19 - 1:57 下午
 */
@Service
@Component
@AllArgsConstructor
public class JiaoshiServiceImpl implements JiaoshiService {
    @Autowired
    JiaoshiMapper jiaoshiMapper;

    @Override
    public List<Map<String,String>> getAllJiaoshi() {
        return jiaoshiMapper.getAllJiaoshi();
    }

    @Override
    public int insertJiaoshi(Jiaoshi jiaoshi) {
        return jiaoshiMapper.insertJiaoshi(jiaoshi);
    }

    @Override
    public int deleteSingleJiaoshi(int jiaoshi_id) {
        return jiaoshiMapper.deleteSingleJiaoshi(jiaoshi_id);
    }

    @Override
    public int updateSingleJiaoshi(Jiaoshi jiaoshi) {
        return jiaoshiMapper.updateSingleJiaoshi(jiaoshi);
    }
}
