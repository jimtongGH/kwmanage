package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Loginip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface LoginipMapper {
    //增加登录ip信息
    int insertLoginip(Loginip loginip);
    //通过用户id查十条信息
    List<Map<String, String>> getAllLoginipByUserId(@Param("user_id") String user_id);
}
