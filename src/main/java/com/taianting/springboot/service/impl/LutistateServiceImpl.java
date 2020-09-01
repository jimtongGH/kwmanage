package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.LutistateMapper;
import com.taianting.springboot.model.Lutistate;
import com.taianting.springboot.service.LutistateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class LutistateServiceImpl implements LutistateService {
    @Autowired
    LutistateMapper lutistateMapper;

    @Override
    public int addLururen(Lutistate lutistate) {
        return lutistateMapper.addLururen(lutistate);
    }

    @Override
    public int addShenheren(Lutistate lutistate) {
        return lutistateMapper.addShenheren(lutistate);
    }

    @Override
    public int updateLurustateByLutiIdAndLururenId(Lutistate lutistate) {
        return lutistateMapper.updateLurustateByLutiIdAndLururenId(lutistate);
    }

    @Override
    public int updateShenhestate(int luti_id) {
        return lutistateMapper.updateShenhestate(luti_id);
    }

    @Override
    public int updateStateAsShenhezhong(int luti_id) {
        return lutistateMapper.updateStateAsShenhezhong(luti_id);
    }

    @Override
    public int updateShenhestateByLutiIdAndShenherenId(Lutistate lutistate) {
        return lutistateMapper.updateShenhestateByLutiIdAndShenherenId(lutistate);
    }

    @Override
    public int updateState(int luti_id) {
        return lutistateMapper.updateState(luti_id);
    }
}
