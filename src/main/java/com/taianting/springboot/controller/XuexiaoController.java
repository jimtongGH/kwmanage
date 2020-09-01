package com.taianting.springboot.controller;

import com.taianting.springboot.model.Xuexiao;
import com.taianting.springboot.service.XuexiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class XuexiaoController {
    @Autowired
    XuexiaoService xuexiaoService;

    //查找所有的学校
    @CrossOrigin
    @GetMapping(value = "/manage/xuexiao/getAll")
    @ResponseBody
    public Map<String, Object> getAllXuexiao () throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String ,String>> xuexiao = xuexiaoService.getAllXuexiao();
        if(xuexiao == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有学校信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", xuexiao);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //新增学校
    @CrossOrigin
    @RequestMapping(value = "/manage/xuexiao/insertXuexiao")
    @ResponseBody
    public Map<String, Object> insertXuexiao (Xuexiao xuexiao) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String xuexiao_mingcheng = xuexiao.getXuexiao_mingcheng();
        Xuexiao xuexiao1 = new Xuexiao(xuexiao_mingcheng);
        int flag = xuexiaoService.insertXuexiao(xuexiao1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","添加成功！");
            resultMap.put("result", xuexiao1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "添加失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //软删除单条记录
    @CrossOrigin
    @RequestMapping(value = "/manage/xuexiao/deleteSingleXuexiao")
    @ResponseBody
    public Map<String, Object> deleteSingleXuexiao (Xuexiao xuexiao) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int xuexiao_id = xuexiao.getXuexiao_id();
        int flag = xuexiaoService.deleteSingleXuexiao(xuexiao_id);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","删除成功!");
            resultMap.put("result", xuexiao_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //更改单条记录
    @CrossOrigin
    @RequestMapping(value = "/manage/xuexiao/updateSingleXuexiao")
    @ResponseBody
    public Map<String, Object> updateSingleXuexiao (Xuexiao xuexiao) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int xuexiao_id = xuexiao.getXuexiao_id();
        String xuexiao_mingcheng = xuexiao.getXuexiao_mingcheng();
        Xuexiao xuexiao1 = new Xuexiao(xuexiao_id, xuexiao_mingcheng);
        System.out.println(xuexiao1);
        int flag = xuexiaoService.updateSingleXuexiao(xuexiao1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","更改成功!");
            resultMap.put("result", xuexiao1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }
}
