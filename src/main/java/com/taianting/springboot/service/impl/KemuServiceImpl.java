package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.KemuMapper;
import com.taianting.springboot.model.Kemu;
import com.taianting.springboot.service.KemuService;
import com.taianting.springboot.redis.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class KemuServiceImpl implements KemuService {
    @Autowired
    KemuMapper kemuMapper;

    @Autowired
    RedisService redisService;

    @Override
    public List<Map<String, String>> getAllKemu() {
        List<Map<String,String>> allKemu = (List<Map<String, String>>) redisService.get("allKemu");
        if(allKemu == null){
            //使用同步锁解决并发的缓存穿透问题，让并发用户一个一个通过
            //只有单例的时候才可以用this，而IOC容器默认单例，不是单例时候使用KemuServiceImpl.class
            synchronized (this){
                //第一个进来查
                allKemu = (List<Map<String, String>>) redisService.get("allKemu");
                //没有值的话，进入MySQL查询，否则不用去调用MySQL
                if(allKemu == null){
                    allKemu = kemuMapper.getAllKemu();
                    redisService.set("allKemu",allKemu);
                }
            }
        }
        return allKemu;
    }

    @Override
    public int insertKemu(Kemu kemu) {
        redisService.delete("allKemu");
        return kemuMapper.insertKemu(kemu);
    }

    @Override
    public int deleteSingleKemu(int kemu_id) {
        redisService.delete("allKemu");
        return kemuMapper.deleteSingleKemu(kemu_id);
    }

    @Override
    public int updateSingleKemu(Kemu kemu) {
        redisService.delete("allKemu");
        return kemuMapper.updateSingleKemu(kemu);
    }
}
