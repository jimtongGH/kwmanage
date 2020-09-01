package com.taianting.springboot.service;

import com.taianting.springboot.model.Luti;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LutiService {
    int addLuti(Luti luti);
    List<Map<String, String>> getAllLuti();
    int deleteSingleLuti(@Param("luti_id") int luti_id);
    List<Map<String, String>> getAllLutiByLururenId(@Param("lutistate_lururenid") String lutistate_lururenid);
    int countLurustateByLutiId(@Param("luti_id") int luti_id);
    List<Map<String, String>> getDoneLutiByLururenId(@Param("lutistate_lururenid") String lutistate_lururenid);
    List<Map<String, String>> getAllShenheByShenherenId(@Param("lutistate_shenherenid") String lutistate_shenherenid);
    int countShenhestateByLutiId(@Param("luti_id") int luti_id);
    List<Map<String, String>> getDoneShenheByShenherenId(@Param("lutistate_shenherenid") String lutistate_shenherenid);
}
