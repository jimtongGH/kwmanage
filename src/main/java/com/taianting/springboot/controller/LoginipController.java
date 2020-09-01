package com.taianting.springboot.controller;

import cn.hutool.core.date.DateUtil;
import com.taianting.springboot.model.Loginip;
import com.taianting.springboot.model.Users;
import com.taianting.springboot.service.LoginipService;
import com.taianting.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginipController {
    @Autowired
    LoginipService loginipService;
    @Autowired
    UsersService usersService;

    //增加登录信息
    @CrossOrigin
    @RequestMapping(value = "/loginip/insert")
    @ResponseBody
    public Map<String, Object> insertLoginip(Loginip loginip, HttpSession httpSession){
        Map<String, Object> resultMap = new HashMap<>();
        String ip_date = (DateUtil.date(System.currentTimeMillis())).toString();
        String ip_city = loginip.getIp_city();
        String ip_ip = loginip.getIp_ip();
        String ip_device = loginip.getIp_device();
        String ip_OS = loginip.getIp_OS();

        //登录人id
        Map<String,String> users = (Map<String, String>) httpSession.getAttribute("users");
        String user_id = users.get("user_id");

        Loginip loginip1 = new Loginip(user_id,ip_date,ip_city,ip_ip,ip_device,ip_OS);
        int flag = loginipService.insertLoginip(loginip1);
        if(flag != -1){
            resultMap.put("code",200);
            resultMap.put("msg","添加成功！");
            resultMap.put("result", loginip1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "添加失败！");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //通过userID查找登录信息
    @CrossOrigin
    @RequestMapping(value = "/loginip/getAllByUserId")
    @ResponseBody
    public Map<String, Object> getAllByUserId(Users users){
        Map<String, Object> resultMap = new HashMap<>();
        //从前端localStorage获取user_id
        String user_id = users.getUser_id();
        List<Map<String,String>> loginip = loginipService.getAllLoginipByUserId(user_id);
        if(loginip == null){
            resultMap.put("code",201);
            resultMap.put("msg","没有登录信息详情");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "查找成功");
            resultMap.put("result", loginip);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }
}
