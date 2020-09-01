package com.taianting.springboot.service;

import com.taianting.springboot.model.Netdisk;

import java.util.List;
import java.util.Map;

public interface NetdiskService {
    int addFile(Netdisk netdisk);
    List<Map<String, String>> getAllFile();
    List<Map<String, String>> getAllFileByUserId(String user_id);
    List<Map<String, String>> getRecoverFileByUserId(String user_id);
    int deleteByNetdiskId(int netdisk_id);
    int deleteForeverByNetdiskId(int netdisk_id);
    int recoverFile(int netdisk_id);
    int updateSingleFile(Netdisk netdisk);
}
