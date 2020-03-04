package com.taianting.springboot.controller;

import com.taianting.springboot.model.Kaoshi;
import com.taianting.springboot.service.KaoshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2019/12/26 - 2:18 下午
 */

@RestController
public class KaoshiController {
    @Autowired
    private KaoshiService kaoshiService;

    //查找所有的教师
    @CrossOrigin
    @GetMapping(value = "api/kaowu/kaoshi/getAllByXueqiId")
    @ResponseBody
    public Map<String, Object> getAllJiaoshi(Kaoshi kaoshi, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> resultMap = new HashMap<>();
        int xueqi_id = kaoshi.getXueqi_id();
        List<Map<String,String>> kaowu1 = kaoshiService.getAllKaowuByXueqiId(xueqi_id);
        if(kaowu1 == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有教师信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", kaowu1);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }
}
