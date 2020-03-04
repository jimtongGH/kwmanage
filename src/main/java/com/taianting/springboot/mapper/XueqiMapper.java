package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Xueqi;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface XueqiMapper {
    //查找所有的学期
    List<Map<String ,String>> getAllXueqi();

    //新增学期信息
    int insertXueqi(Xueqi xueqi);

    //软删除单条记录
    int deleteSingleXueqi(@Param("xueqi_id") int xueqi_id);

    //修改单条记录
    int updateSingleXueqi(Xueqi xueqi);
}