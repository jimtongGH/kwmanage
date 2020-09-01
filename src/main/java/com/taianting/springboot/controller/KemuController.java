package com.taianting.springboot.controller;

import com.taianting.springboot.model.Kemu;
import com.taianting.springboot.service.KemuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KemuController {

    @Autowired
    private KemuService kemuService;

    //查找所有的科目
    @CrossOrigin
    @GetMapping(value = "/manage/kemu/getAll")
    @ResponseBody
    public Map<String, Object> getAllKemu () throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String ,String>> kemu = kemuService.getAllKemu();
        if(kemu == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有科目信息");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", kemu);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //新增科目
    @CrossOrigin
    @RequestMapping(value = "/manage/kemu/insertKemu")
    @ResponseBody
    public Map<String, Object> insertkemu (Kemu kemu) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String kemu_mingcheng = kemu.getKemu_mingcheng();
        Kemu kemu1 = new Kemu(kemu_mingcheng);
        int flag = kemuService.insertKemu(kemu1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","添加成功！");
            resultMap.put("result", kemu1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "添加失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //软删除单条记录
    @CrossOrigin
    @RequestMapping(value = "/manage/kemu/deleteSingleKemu")
    @ResponseBody
    public Map<String, Object> deleteSinglekemu (Kemu kemu) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int kemu_id = kemu.getKemu_id();
        int flag = kemuService.deleteSingleKemu(kemu_id);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","删除成功!");
            resultMap.put("result", kemu_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //更改单条记录
    @CrossOrigin
    @RequestMapping(value = "/manage/kemu/updateSingleKemu")
    @ResponseBody
    public Map<String, Object> updateSinglekemu (Kemu kemu) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int kemu_id = kemu.getKemu_id();
        String kemu_mingcheng = kemu.getKemu_mingcheng();
        Kemu kemu1 = new Kemu(kemu_id, kemu_mingcheng);
        int flag = kemuService.updateSingleKemu(kemu1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","更改成功!");
            resultMap.put("result", kemu1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }
}
