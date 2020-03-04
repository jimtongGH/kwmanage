package com.taianting.springboot.service;

import com.taianting.springboot.model.Users;

import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2020/1/9 - 10:28 上午
 */
public interface UsersService  {
    Map<String,String> findUsersByLUN(String login_username);
    int addUsers(Users users);
}
