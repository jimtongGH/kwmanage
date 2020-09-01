package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.NetdiskMapper;
import com.taianting.springboot.model.Netdisk;
import com.taianting.springboot.redis.RedisService;
import com.taianting.springboot.service.NetdiskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class NetdiskServiceImpl implements NetdiskService {
    @Autowired
    NetdiskMapper netdiskMapper;

    @Autowired
    RedisService redisService;

    @Override
    public List<Map<String, String>> getAllFile() {
        redisService.delete("allFile");
        List<Map<String,String>> allFile = (List<Map<String, String>>) redisService.get("allFile");
        if(allFile == null){
            //使用同步锁解决并发的缓存穿透问题，让并发用户一个一个通过
            //只有单例的时候才可以用this，而IOC容器默认单例，不是单例时候使用NetdiskServiceImpl.class
            synchronized (this){
                //第一个进来查
                allFile = (List<Map<String, String>>) redisService.get("allFile");
                //没有值的话，进入MySQL查询，否则不用去调用MySQL
                if(allFile == null){
                    allFile = netdiskMapper.getAllFile();
                    redisService.set("allFile",allFile);
                }
            }
        }
        return allFile;
    }

    @Override
    public int addFile(Netdisk netdisk) {
        redisService.delete("allFile");
        return netdiskMapper.addFile(netdisk);
    }

    @Override
    public List<Map<String, String>> getAllFileByUserId(String user_id) {
        return netdiskMapper.getAllFileByUserId(user_id);
    }

    @Override
    public List<Map<String, String>> getRecoverFileByUserId(String user_id) {
        return netdiskMapper.getRecoverFileByUserId(user_id);
    }

    @Override
    public int deleteByNetdiskId(int netdisk_id) {
        redisService.delete("allFile");
        return netdiskMapper.deleteByNetdiskId(netdisk_id);
    }

    @Override
    public int deleteForeverByNetdiskId(int netdisk_id) {
        return netdiskMapper.deleteForeverByNetdiskId(netdisk_id);
    }

    @Override
    public int recoverFile(int netdisk_id) {
        return netdiskMapper.recoverFile(netdisk_id);
    }

    @Override
    public int updateSingleFile(Netdisk netdisk) {
        return netdiskMapper.updateSingleFile(netdisk);
    }
}
