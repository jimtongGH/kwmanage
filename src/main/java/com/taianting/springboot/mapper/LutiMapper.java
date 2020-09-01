package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Luti;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface LutiMapper {
    //添加luti任务
    int addLuti(Luti luti);

    //查找所有录题信息
    List<Map<String, String>> getAllLuti();

    //删除同一id记录
    int deleteSingleLuti(@Param("luti_id") int luti_id);

    //查找自己未完成的录入任务
    List<Map<String, String>> getAllLutiByLururenId(@Param("lutistate_lururenid") String lutistate_lururenid);

    //统计同一lutiid下录入进行中的数量
    int countLurustateByLutiId(@Param("luti_id") int luti_id);

    //查询自己录入完成
    List<Map<String, String>> getDoneLutiByLururenId(@Param("lutistate_lururenid") String lutistate_lururenid);

    //查找自己未完成的审核任务
    List<Map<String, String>> getAllShenheByShenherenId(@Param("lutistate_shenherenid") String lutistate_shenherenid);

    //统计同一lutiid下审核进行中的数量
    int countShenhestateByLutiId(@Param("luti_id") int luti_id);

    //查询自己审核完成
    List<Map<String, String>> getDoneShenheByShenherenId(@Param("lutistate_shenherenid") String lutistate_shenherenid);
}