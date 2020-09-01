package com.taianting.springboot.controller;

import cn.hutool.core.convert.Convert;
import com.taianting.springboot.model.Users;
import com.taianting.springboot.service.UsersService;
import com.taianting.springboot.util.HttpClientUtil;
import com.taianting.springboot.util.MD5Util;
import com.taianting.springboot.util.SaltUtil;
import com.taianting.springboot.util.UUIDUtil;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, Object> map, HttpSession httpSession) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        //前端取值
        String login_username = map.get("login_username").toString();
        String login_password = map.get("login_password").toString();
        //找出users对象
        Map<String, String> users1 = usersService.findUsersByLUN(login_username);
        if (users1 == null || !users1.get("login_username").equals(login_username)) {
            resultMap.put("code", 202);
            resultMap.put("msg", "账号不存在");
        } else {
            //后端取出盐
            String user_salt = users1.get("user_salt");
            //用hutool转换参数类型
            int user_state = Convert.toInt(users1.get("user_state"));
            int user_level = Convert.toInt(users1.get("user_level"));
            String encodePassword = MD5Util.getMd5(login_password + user_salt,2);
            //校验
            if (encodePassword.equals(users1.get("login_password"))) {
                if(user_state == 0 && (user_level == 1 || user_level == 2)){
                    //账号状态正常，且为普通用户或管理员用户，准许登录
                    //登录存进session
                    httpSession.setAttribute("users", users1);
                    //创建新的user对象返回前端
                    int user_sex = Convert.toInt(users1.get("user_sex"));
                    Users users2 = new Users(users1.get("user_id"),users1.get("login_username"),users1.get("user_name"),user_sex,user_level);
                    resultMap.put("code", 200);
                    resultMap.put("result", users2);
                } else if(user_state == 1){
                    //账号被禁止登录
                    resultMap.put("code", 203);
                    resultMap.put("msg", "账号为禁止登录状态");
                } else if(user_state == 0 && user_level == 0){
                    //账号状态正常，但未验证通过
                    resultMap.put("code", 204);
                    resultMap.put("msg", "账号未通过验证");
                } else if(user_state == 2){
                    //账号已经被删除
                    resultMap.put("code", 205);
                    resultMap.put("msg", "账号已经被删除");
                }
            } else {
                resultMap.put("code", 201);
                resultMap.put("msg", "密码错误");
            }
        }
        return resultMap;
    }

    //注册
    @CrossOrigin
    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<String ,Object> register(@RequestBody Map<String, Object> map) throws Exception {
        Map<String ,Object> resultMap = new HashMap<>();
        //前端取值
        String user_name = String.valueOf(map.get("user_name"));
        String login_username = String.valueOf(map.get("login_username"));
        String login_password = String.valueOf(map.get("login_password"));
        //查找是否重复用户名
        Map<String, String> users = usersService.findUsersByLUN(login_username);
        if (users == null) {
            //UUID
            String user_id = UUIDUtil.getUniqueIdByUUId();
            //用户盐+Md5加密
            // 生成盐16位
            String user_salt = SaltUtil.getRandomStr(16);
            //将用户盐和用户输入的密码一同用Md5加密
            String encodePassword = MD5Util.getMd5(login_password + user_salt,2);
            Users users1 = new Users(user_id, user_name, login_username, encodePassword, user_salt, 0);
            int flag = usersService.addUsers(users1);
            if (flag != -1) {
                try{
                    //成功
                    resultMap.put("code",200);
                    resultMap.put("result",users1);
                } catch (Exception e) {
                    resultMap.put("code",201);
                    resultMap.put("msg","注册失败");
                }
            }
        } else {
            resultMap.put("code",202);
            resultMap.put("msg","账号已存在");
        }
        return resultMap;
    }

    //修改密码
    @CrossOrigin
    @RequestMapping(value = "/passChange")
    @ResponseBody
    public Map<String, Object> passChange(@RequestBody Map<String, Object> map,Users users, HttpSession httpSession) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        //前端取值
        String oldpassword = map.get("oldpassword").toString();
        String newpassword = map.get("newpassword").toString();
        String user_id = map.get("user_id").toString();
        //找出users对象
        Map<String, String> users1 = usersService.findUsersByUserId(user_id);
        //后端取出盐
        String user_salt = users1.get("user_salt");
        String encodePassword = MD5Util.getMd5(oldpassword + user_salt,2);
        //校验
        if (encodePassword.equals(users1.get("login_password"))) {
            // 生成盐16位
            String newuser_salt = SaltUtil.getRandomStr(16);
            String newEncodePassword = MD5Util.getMd5(newpassword + newuser_salt,2);
            Users users2 = new Users(user_id,newuser_salt,newEncodePassword,0);
            int flag = usersService.updateUsersPassword(users2);
            if(flag != -1){
                resultMap.put("code", 200);
                resultMap.put("result", users2);
            } else {
                resultMap.put("code", 202);
                resultMap.put("msg", "错误");
            }
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "密码错误");
        }

        return resultMap;
    }

    //密码重置
    @CrossOrigin
    @RequestMapping(value = "/passReplace")
    @ResponseBody
    public Map<String, Object> passReplace(Users users) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        //校验
        // 生成盐16位
        String newuser_salt = SaltUtil.getRandomStr(16);
        String newpassword = "jidegaimima1234";
        String newEncodePassword = MD5Util.getMd5(newpassword + newuser_salt,2);
        Users users1 = new Users(user_id,newuser_salt,newEncodePassword,0);
        int flag = usersService.updateUsersPassword(users1);
        if(flag != -1){
            resultMap.put("code", 200);
            resultMap.put("result", users1);
        } else {
            resultMap.put("code", 202);
            resultMap.put("msg", "错误");
        }
        return resultMap;
    }

    //登出
    @CrossOrigin
    @GetMapping("/logout")
    @ResponseBody
    public Map<String ,Object> logout(HttpSession httpSession) {
        Map<String ,Object> resultMap = new HashMap<>();
        //session失效
        try {
            httpSession.invalidate();
            resultMap.put("code",200);
            resultMap.put("msg","成功登出");
        } catch (Exception e){
            resultMap.put("code",201);
            resultMap.put("msg","e");
        }
        return resultMap;
    }

    //APP_VAR
    @CrossOrigin
    @GetMapping("/getAppVar")
    @ResponseBody
    public Map<String ,Object> getAppVar (){
        Map<String ,Object> resultMap = new HashMap<>();
        String url = "https://www.zhifz.com/app_ver";
        System.out.println("请求url:" + url);
        try {
            String result = HttpClientUtil.doGet(url);
            System.out.println("请求结果：" + result);
            //成功
            String tmp = StringEscapeUtils.unescapeJson(result);
            resultMap.put("code" ,200);
            resultMap.put("result", tmp);
            return resultMap;
        } catch (Exception e) {
            resultMap.put("code" , 201);
            resultMap.put("msg", "获取app版本失败");
            return resultMap;
        }
    }

    //个人信息展示
    @CrossOrigin
    @RequestMapping(value = "/person/getInfo")
    @ResponseBody
    public Map<String, Object> getPersonInfo (Users users){
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        Map<String, String> users1 = usersService.findUsersByUserId(user_id);
        if (users1 != null) {
            resultMap.put("code",200);
            resultMap.put("msg","查找成功");
            resultMap.put("result", users1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg","查找失败");
        }
        return resultMap;
    }

    //个人信息修改
    @CrossOrigin
    @RequestMapping(value = "/person/updateInfo")
    @ResponseBody
    public Map<String, Object> updatePersonInfo (Users users){
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        String user_name = users.getUser_name();
        int user_sex = users.getUser_sex();
        int user_level = users.getUser_level();
        Users users2 = new Users(user_id, user_name, user_sex, user_level);
        int flag = usersService.updateUsersInfo(users2);
        if (flag != -1) {
            resultMap.put("code", 200);
            resultMap.put("msg", "更改成功！");
            resultMap.put("result", users2);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        return resultMap;
    }

    //查找所有userId和userName
    @CrossOrigin
    @RequestMapping(value = "/luti/getIdAndName")
    @ResponseBody
    public Map<String, Object> getIdAndName (){
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String,String>> users = usersService.findUserIdAndName();
        if(users != null){
            resultMap.put("code",200);
            resultMap.put("msg","查找成功");
            resultMap.put("result", users);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg","查找失败");
        }
        return resultMap;
    }

    //查找所有未验证用户
    @CrossOrigin
    @RequestMapping(value = "/users/getSignupUser")
    @ResponseBody
    public Map<String, Object> getSignupUser (){
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String,String>> users = usersService.getSignupUser();
        if(users != null){
            resultMap.put("code",200);
            resultMap.put("msg","查找成功");
            resultMap.put("result", users);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg","查找失败");
        }
        return resultMap;
    }

    //将未验证用户变为用户
    @CrossOrigin
    @RequestMapping(value = "/users/updateSignupUser")
    @ResponseBody
    public Map<String, Object> updateSignupUser (Users users){
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        int flag = usersService.updateSignupUser(user_id);
        if (flag != -1) {
            resultMap.put("code", 200);
            resultMap.put("msg", "更改成功！");
            resultMap.put("result", user_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        return resultMap;
    }

    //查找所有用户
    @CrossOrigin
    @RequestMapping(value = "/users/getYonghu")
    @ResponseBody
    public Map<String, Object> getYonghu (){
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String,String>> users = usersService.getYonghu();
        if(users != null){
            resultMap.put("code",200);
            resultMap.put("msg","查找成功");
            resultMap.put("result", users);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg","查找失败");
        }
        return resultMap;
    }

    //修改用户状态
    @CrossOrigin
    @RequestMapping(value = "/users/updateUserState")
    @ResponseBody
    public Map<String, Object> updateUserState (Users users){
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        Integer user_state = users.getUser_state();
        Users users1 = new Users(user_id,user_state);
        int flag = usersService.updateUserState(users1);
        if (flag != -1) {
            resultMap.put("code", 200);
            resultMap.put("msg", "更改成功！");
            resultMap.put("result", users1);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "更改失败！");
        }
        return resultMap;
    }

    //删除用户
    @CrossOrigin
    @RequestMapping(value = "/users/deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser (Users users){
        Map<String, Object> resultMap = new HashMap<>();
        String user_id = users.getUser_id();
        int flag = usersService.deleteUser(user_id);
        if (flag != -1) {
            resultMap.put("code", 200);
            resultMap.put("msg", "删除成功！");
            resultMap.put("result", user_id);
        } else {
            resultMap.put("code", 201);
            resultMap.put("msg", "删除失败！");
        }
        return resultMap;
    }
}
