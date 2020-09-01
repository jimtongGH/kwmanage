package com.taianting.springboot.service;

import com.taianting.springboot.model.Kaoshi;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2019/12/27 - 3:03 下午
 */
public interface KaoshiService {
    List<Map<String, String>> getAllKaoshiByXueqiId(int xueqi_id);
    int insertKaoshi(Kaoshi kaoshi);
    int deleteSingleKaoshi(@Param("kaoshi_id") int kaoshi_id);
    int updateSingleKaoshi(Kaoshi kaoshi);
}
