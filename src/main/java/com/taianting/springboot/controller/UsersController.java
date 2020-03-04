package com.taianting.springboot.controller;

import com.taianting.springboot.model.Users;
import com.taianting.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2020/1/9 - 12:16 下午
 */
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    //登录
    @CrossOrigin
    @RequestMapping(value = "api/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, Object> map,HttpServletRequest request, HttpServletResponse response,
                                        HttpSession session) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> resultMap = new HashMap<>();
        String login_username = map.get("login_username").toString();
        String login_password = map.get("login_password").toString();
        Map<String,String> users = usersService.findUsersByLUN(login_username);
        if (users == null || !users.get("login_username").equals(login_username)) {
            resultMap.put("code", 202);
            resultMap.put("msg", "账号不存在");
        } else if (!users.get("login_password").equals(login_password)) {
            resultMap.put("code", 201);
            resultMap.put("msg", "密码错误");
        } else {
            resultMap.put("code", 200);
            resultMap.put("msg", "登陆成功");
            resultMap.put("result", users);
            request.getSession().setAttribute("users", users);
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }

    //注册
    @CrossOrigin
    @RequestMapping(value = "api/register")
    @ResponseBody
    public Map<String, Object> register(@RequestBody Map<String, Object> map,HttpServletRequest request, HttpServletResponse response,
                                        HttpSession session) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> resultMap = new HashMap<>();
        String user_name = String.valueOf(map.get("user_name"));
        String login_username = String.valueOf(map.get("login_username"));
        String login_password = String.valueOf(map.get("login_password"));
        Map<String,String> users = usersService.findUsersByLUN(login_username);
        if(users == null){
            Users users1 = new Users(user_name,login_username,login_password);
            int flag = usersService.addUsers(users1);
            if (flag != -1) {
                resultMap.put("code", 200);
                resultMap.put("msg", "注册成功");
            } else {
                resultMap.put("code", 201);
                resultMap.put("msg", "注册失败");
            }
        } else {
            resultMap.put("code", 202);
            resultMap.put("msg", "账号已存在");
        }
        System.out.println("resultMap:"+resultMap);
        return resultMap;
    }
}
