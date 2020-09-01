package com.taianting.springboot.service.impl;

import com.taianting.springboot.mapper.UsersMapper;
import com.taianting.springboot.model.Users;
import com.taianting.springboot.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Map<String, String> findUsersByUserId(String user_id) {
        return usersMapper.findUsersByUserId(user_id);
    }

    @Override
    public List<Map<String,String>> findUserIdAndName() {
        return usersMapper.findUserIdAndName();
    }

    @Override
    public int addUsers(Users users) {
        return usersMapper.addUsers(users);
    }

    @Override
    public int updateUsersInfo(Users users) {
        return usersMapper.updateUsersInfo(users);
    }

    @Override
    public int updateUsersPassword(Users users) {
        return usersMapper.updateUsersPassword(users);
    }

    @Override
    public List<Map<String, String>> getSignupUser() {
        return usersMapper.getSignupUser();
    }

    @Override
    public int updateSignupUser(String user_id) {
        return usersMapper.updateSignupUser(user_id);
    }

    @Override
    public List<Map<String, String>> getYonghu() {
        return usersMapper.getYonghu();
    }

    @Override
    public int updateUserState(Users users) {
        return usersMapper.updateUserState(users);
    }

    @Override
    public int deleteUser(String user_id) {
        return usersMapper.deleteUser(user_id);
    }
}
