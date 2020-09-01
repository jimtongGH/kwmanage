package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.XuexiaoMapper;
import com.taianting.springboot.model.Xuexiao;
import com.taianting.springboot.redis.RedisService;
import com.taianting.springboot.service.XuexiaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class XuexiaoServiceImpl implements XuexiaoService {
    @Autowired
    XuexiaoMapper xuexiaoMapper;

    @Autowired
    RedisService redisService;

    @Override
    public List<Map<String, String>> getAllXuexiao() {
        List<Map<String,String>> allXuexiao = (List<Map<String, String>>) redisService.get("allXuexiao");
        if(allXuexiao == null){
            //使用同步锁解决并发的缓存穿透问题，让并发用户一个一个通过
            //只有单例的时候才可以用this，而IOC容器默认单例，不是单例时候使用XuexiaoServiceImpl.class
            synchronized (this){
                //第一个进来查
                allXuexiao = (List<Map<String, String>>) redisService.get("allXuexiao");
                //没有值的话，进入MySQL查询，否则不用去调用MySQL
                if(allXuexiao == null){
                    allXuexiao = xuexiaoMapper.getAllXuexiao();
                    redisService.set("allXuexiao",allXuexiao);
                }
            }
        }
        return allXuexiao;
    }

    @Override
    public int insertXuexiao(Xuexiao xuexiao) {
        redisService.delete("allXuexiao");
        return xuexiaoMapper.insertXuexiao(xuexiao);
    }

    @Override
    public int deleteSingleXuexiao(int xuexiao_id) {
        redisService.delete("allXuexiao");
        return xuexiaoMapper.deleteSingleXuexiao(xuexiao_id);
    }

    @Override
    public int updateSingleXuexiao(Xuexiao xuexiao) {
        redisService.delete("allXuexiao");
        return xuexiaoMapper.updateSingleXuexiao(xuexiao);
    }
}
