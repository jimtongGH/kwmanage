package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Netdisk;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface NetdiskMapper {
    //新增文件
    int addFile(Netdisk netdisk);

    //查找所有文件，后添加文件在前显示
    List<Map<String, String>> getAllFile();

    //通过user_id查找所有文件，后添加文件在前显示
    List<Map<String, String>> getAllFileByUserId(String user_id);

    //通过user_id查找所有已经删除文件，后添加文件在前显示
    List<Map<String, String>> getRecoverFileByUserId(String user_id);

    //通过修改状态达到软删除目的
    int deleteByNetdiskId(int netdisk_id);

    //永久软删除
    int deleteForeverByNetdiskId(int netdisk_id);

    //还原文件
    int recoverFile(int netdisk_id);

    //更新文件信息
    int updateSingleFile(Netdisk netdisk);
}
