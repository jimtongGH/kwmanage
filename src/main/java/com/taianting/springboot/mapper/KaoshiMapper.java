package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Kaoshi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface KaoshiMapper {
    //通过学期Id，查找所有教师，以及教师所属的学校名称
    List<Map<String, String>> getAllKaoshiByXueqiId(@Param("xueqi_id") int xueqi_id);

    //增加新的考试信息
    int insertKaoshi(Kaoshi kaoshi);

    //删除单条记录
    int deleteSingleKaoshi(@Param("kaoshi_id") int kaoshi_id);

    //修改单条记录
    int updateSingleKaoshi(Kaoshi kaoshi);
}