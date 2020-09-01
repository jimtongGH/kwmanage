package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Lutistate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LutistateMapper {
    //新增录入人
    int addLururen(Lutistate lutistate);

    //新增审核人
    int addShenheren(Lutistate lutistate);

    //修改录入状态为已完成
    int updateLurustateByLutiIdAndLururenId(Lutistate lutistate);

    //修改审核状态为进行中
    int updateShenhestate(@Param("luti_id") int luti_id);

    //修改总状态为审核中
    int updateStateAsShenhezhong(@Param("luti_id") int luti_id);

    //修改审核状态为已完成
    int updateShenhestateByLutiIdAndShenherenId(Lutistate lutistate);

    //修改总状态为结束
    int updateState(@Param("luti_id") int luti_id);
}
