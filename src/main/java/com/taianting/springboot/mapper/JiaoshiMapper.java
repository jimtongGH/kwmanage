package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Jiaoshi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface JiaoshiMapper {
    //查找所有教师，以及教师所属的学校名称
    List<Map<String, String>> getAllJiaoshi();

    //通过学校ID找教师姓名
    List<Map<String, String>> getJiaoshiXingmingByXuexiaoId(@Param("xuexiao_id") int xuexiao_id);

    //新增教师
    int insertJiaoshi(Jiaoshi jiaoshi);

    //软删除单条记录
    int deleteSingleJiaoshi(@Param("jiaoshi_id") int jiaoshi_id);

    //修改单条记录
    int updateSingleJiaoshi(Jiaoshi jiaoshi);
}
