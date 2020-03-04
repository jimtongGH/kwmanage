package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.UsersMapper;
import com.taianting.springboot.model.Users;
import com.taianting.springboot.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2020/1/9 - 10:19 上午
 */
@Service
@Component
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;


    @Override
    public Map<String,String> findUsersByLUN(String login_username) {
        return usersMapper.findUsersByLUN(login_username);
    }

    @Override
    public int addUsers(Users users) {
        return usersMapper.addUsers(users);
    }
}
