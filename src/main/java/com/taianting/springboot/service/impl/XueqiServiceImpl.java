package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.XueqiMapper;
import com.taianting.springboot.model.Xueqi;
import com.taianting.springboot.redis.RedisService;
import com.taianting.springboot.service.XueqiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class XueqiServiceImpl implements XueqiService {
    @Autowired
    XueqiMapper xueqiMapper;

    @Autowired
    RedisService redisService;

    @Override
    public List<Map<String, String>> getAllXueqi() {
        List<Map<String,String>> allXueqi = (List<Map<String, String>>) redisService.get("allXueqi");
        if(allXueqi == null){
            //使用同步锁解决并发的缓存穿透问题，让并发用户一个一个通过
            //只有单例的时候才可以用this，而IOC容器默认单例，不是单例时候使用XueqiServiceImpl.class
            synchronized (this){
                //第一个进来查
                allXueqi = (List<Map<String, String>>) redisService.get("allXueqi");
                //没有值的话，进入MySQL查询，否则不用去调用MySQL
                if(allXueqi == null){
                    allXueqi = xueqiMapper.getAllXueqi();
                    redisService.set("allXueqi",allXueqi);
                }
            }
        }
        return allXueqi;
    }

    @Override
    public int insertXueqi(Xueqi xueqi) {
        redisService.delete("allXueqi");
        return xueqiMapper.insertXueqi(xueqi);
    }

    @Override
    public int deleteSingleXueqi(int xueqi_id) {
        redisService.delete("allXueqi");
        return xueqiMapper.deleteSingleXueqi(xueqi_id);
    }

    @Override
    public int updateSingleXueqi(Xueqi xueqi) {
        redisService.delete("allXueqi");
        return xueqiMapper.updateSingleXueqi(xueqi);
    }
}
