package com.taianting.springboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface KaoshiMapper {
    //通过学期Id，查找所有教师，以及教师所属的学校名称
    List<Map<String, String>> getAllKaowuByXueqiId(@Param("xueqi_id") int xueqi_id);
}