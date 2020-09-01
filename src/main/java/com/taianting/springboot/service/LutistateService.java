package com.taianting.springboot.service;

import com.taianting.springboot.model.Lutistate;
import org.apache.ibatis.annotations.Param;

public interface LutistateService {
    int addLururen(Lutistate lutistate);
    int addShenheren(Lutistate lutistate);
    int updateLurustateByLutiIdAndLururenId(Lutistate lutistate);
    int updateShenhestate(@Param("luti_id") int luti_id);
    int updateStateAsShenhezhong(@Param("luti_id") int luti_id);
    int updateShenhestateByLutiIdAndShenherenId(Lutistate lutistate);
    int updateState(@Param("luti_id") int luti_id);
}
