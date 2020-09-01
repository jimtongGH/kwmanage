package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.JiaoshiMapper;
import com.taianting.springboot.model.Jiaoshi;
import com.taianting.springboot.redis.RedisService;
import com.taianting.springboot.service.JiaoshiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2020/2/19 - 1:57 下午
 */
@Service
@Component
@AllArgsConstructor
public class JiaoshiServiceImpl implements JiaoshiService {
    @Autowired
    JiaoshiMapper jiaoshiMapper;

    @Autowired
    RedisService redisService;

    @Override
    public List<Map<String,String>> getAllJiaoshi() {
        List<Map<String,String>> allJiaoshi = (List<Map<String, String>>) redisService.get("allJiaoshi");
        if(allJiaoshi == null){
            //使用同步锁解决并发的缓存穿透问题，让并发用户一个一个通过
            //只有单例的时候才可以用this，而IOC容器默认单例，不是单例时候使用JiaoshiServiceImpl.class
            synchronized (this){
                //第一个进来查
                allJiaoshi = (List<Map<String, String>>) redisService.get("allJiaoshi");
                //没有值的话，进入MySQL查询，否则不用去调用MySQL
                if(allJiaoshi == null){
                    allJiaoshi = jiaoshiMapper.getAllJiaoshi();
                    redisService.set("allJiaoshi",allJiaoshi);
                }
            }
        }
        return allJiaoshi;
    }

    @Override
    public List<Map<String,String>> getJiaoshiXingmingByXuexiaoId(int xuexiao_id) {
        return jiaoshiMapper.getJiaoshiXingmingByXuexiaoId(xuexiao_id);
    }

    @Override
    public int insertJiaoshi(Jiaoshi jiaoshi) {
        redisService.delete("allJiaoshi");
        return jiaoshiMapper.insertJiaoshi(jiaoshi);
    }

    @Override
    public int deleteSingleJiaoshi(int jiaoshi_id) {
        redisService.delete("allJiaoshi");
        return jiaoshiMapper.deleteSingleJiaoshi(jiaoshi_id);
    }

    @Override
    public int updateSingleJiaoshi(Jiaoshi jiaoshi) {
        redisService.delete("allJiaoshi");
        return jiaoshiMapper.updateSingleJiaoshi(jiaoshi);
    }
}
