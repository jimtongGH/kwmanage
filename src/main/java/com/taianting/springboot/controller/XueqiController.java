package com.taianting.springboot.controller;

import com.taianting.springboot.model.Xueqi;
import com.taianting.springboot.service.XueqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class XueqiController {
    @Autowired
    XueqiService xueqiService;

    //查找所有的学期
    @CrossOrigin
    @GetMapping(value = "api/manage/xueqi/getAll")
    @ResponseBody
    public Map<String, Object> getAllXuexiao (HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String ,String>> xueqi = xueqiService.getAllXueqi();
        if(xueqi == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有学期信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", xueqi);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //新增学期
    @CrossOrigin
    @RequestMapping(value = "api/manage/xueqi/insertXueqi")
    @ResponseBody
    public Map<String, Object> insertXueqi (Xueqi xueqi,HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> resultMap = new HashMap<>();
        String xueqi_mingcheng = xueqi.getXueqi_mingcheng();
        Xueqi xueqi1 = new Xueqi(xueqi_mingcheng);
        int flag = xueqiService.insertXueqi(xueqi1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","添加成功！");
            resultMap.put("result", xueqi1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "添加失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //软删除单条记录
    @CrossOrigin
    @RequestMapping(value = "api/manage/xueqi/deleteSingleXueqi")
    @ResponseBody
    public Map<String, Object> deleteSingleXueqi (Xueqi xueqi,HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> resultMap = new HashMap<>();
        int xueqi_id = xueqi.getXueqi_id();
        int flag = xueqiService.deleteSingleXueqi(xueqi_id);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","删除成功!");
            resultMap.put("result", xueqi_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //更改单条记录
    @CrossOrigin
    @RequestMapping(value = "api/manage/xueqi/updateSingleXueqi")
    @ResponseBody
    public Map<String, Object> updateSingleXueqi (Xueqi xueqi,HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> resultMap = new HashMap<>();
        int xueqi_id = xueqi.getXueqi_id();
        String xueqi_mingcheng = xueqi.getXueqi_mingcheng();
        Xueqi xueqi1 = new Xueqi(xueqi_id, xueqi_mingcheng);
        int flag = xueqiService.updateSingleXueqi(xueqi1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","更改成功!");
            resultMap.put("result", xueqi1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }
}
