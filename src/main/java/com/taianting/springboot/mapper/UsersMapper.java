package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Users;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UsersMapper {
    //通过login_username查找user
    Map<String,String> findUsersByLUN(String login_username);

    //注册,添加用户
    int addUsers(Users users);
}
