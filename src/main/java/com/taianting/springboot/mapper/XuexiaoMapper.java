package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Xuexiao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface XuexiaoMapper {
    //查找所有的学校
    List<Map<String ,String>> getAllXuexiao();

    //新增学校信息
    int insertXuexiao(Xuexiao xuexiao);

    //软删除单条记录
    int deleteSingleXuexiao(@Param("xuexiao_id") int xuexiao_id);

    //修改单条记录
    int updateSingleXuexiao(Xuexiao xuexiao);
}