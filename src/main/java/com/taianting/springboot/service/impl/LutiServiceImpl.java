package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.LutiMapper;
import com.taianting.springboot.model.Luti;
import com.taianting.springboot.service.LutiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class LutiServiceImpl implements LutiService {
    @Autowired
    LutiMapper lutiMapper;

    @Override
    public int addLuti(Luti luti) {
        System.out.println("luti_id:controller"+luti.getLuti_id());
        return lutiMapper.addLuti(luti);
    }

    @Override
    public List<Map<String, String>> getAllLuti() {
        return lutiMapper.getAllLuti();
    }

    @Override
    public int deleteSingleLuti(int luti_id) {
        return lutiMapper.deleteSingleLuti(luti_id);
    }

    @Override
    public List<Map<String, String>> getAllLutiByLururenId(String lutistate_lururenid) {
        return lutiMapper.getAllLutiByLururenId(lutistate_lururenid);
    }

    @Override
    public int countLurustateByLutiId(int luti_id) {
        return lutiMapper.countLurustateByLutiId(luti_id);
    }

    @Override
    public List<Map<String, String>> getDoneLutiByLururenId(String lutistate_lururenid) {
        return lutiMapper.getDoneLutiByLururenId(lutistate_lururenid);
    }

    @Override
    public List<Map<String, String>> getAllShenheByShenherenId(String lutistate_shenherenid) {
        return lutiMapper.getAllShenheByShenherenId(lutistate_shenherenid);
    }

    @Override
    public int countShenhestateByLutiId(int luti_id) {
        return lutiMapper.countShenhestateByLutiId(luti_id);
    }

    @Override
    public List<Map<String, String>> getDoneShenheByShenherenId(String lutistate_shenherenid) {
        return lutiMapper.getDoneShenheByShenherenId(lutistate_shenherenid);
    }
}
