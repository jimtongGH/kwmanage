package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.KaoshiMapper;
import com.taianting.springboot.model.Kaoshi;
import com.taianting.springboot.redis.RedisService;
import com.taianting.springboot.service.KaoshiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class KaoshiServiceImpl implements KaoshiService {
    @Autowired
    KaoshiMapper kaoshiMapper;

    @Autowired
    RedisService redisService;

    @Override
    public List<Map<String, String>> getAllKaoshiByXueqiId(int xueqi_id) {
        redisService.delete("allKaoshi");
        List<Map<String,String>> allKaoshi = (List<Map<String, String>>) redisService.get("allKaoshi");
        if(allKaoshi == null){
            //使用同步锁解决并发的缓存穿透问题，让并发用户一个一个通过
            //只有单例的时候才可以用this，而IOC容器默认单例，不是单例时候使用JiaoshiServiceImpl.class
            synchronized (this){
                //第一个进来查
                allKaoshi = (List<Map<String, String>>) redisService.get("allKaoshi");
                //没有值的话，进入MySQL查询，否则不用去调用MySQL
                if(allKaoshi == null){
                    allKaoshi = kaoshiMapper.getAllKaoshiByXueqiId(xueqi_id);
                    redisService.set("allKaoshi",allKaoshi);
                }
            }
        }
        return allKaoshi;
    }

    @Override
    public int insertKaoshi(Kaoshi kaoshi) {
        redisService.delete("allKaoshi");
        return kaoshiMapper.insertKaoshi(kaoshi);
    }

    @Override
    public int deleteSingleKaoshi(int kaoshi_id) {
        redisService.delete("allKaoshi");
        return kaoshiMapper.deleteSingleKaoshi(kaoshi_id);
    }

    @Override
    public int updateSingleKaoshi(Kaoshi kaoshi) {
        redisService.delete("allKaoshi");
        return kaoshiMapper.updateSingleKaoshi(kaoshi);
    }
}
