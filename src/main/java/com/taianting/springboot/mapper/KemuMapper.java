package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Kemu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface KemuMapper {
    //查找所有的科目
    List<Map<String ,String>> getAllKemu();

    //新增科目信息
    int insertKemu(Kemu kemu);

    //软删除单条记录
    int deleteSingleKemu(@Param("kemu_id") int kemu_id);

    //修改单条记录
    int updateSingleKemu(Kemu kemu);
}