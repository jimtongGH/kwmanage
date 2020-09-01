package com.taianting.springboot.service;

import com.taianting.springboot.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Shengjin Tong
 * @date 2020/1/9 - 10:28 上午
 */
public interface UsersService  {
    Map<String,String> findUsersByLUN(String login_username);
    Map<String,String> findUsersByUserId(String user_id);
    List<Map<String,String>> findUserIdAndName();
    int addUsers(Users users);
    int updateUsersInfo(Users users);
    int updateUsersPassword(Users users);
    List<Map<String,String>> getSignupUser();
    int updateSignupUser(@Param("user_id") String user_id);
    List<Map<String,String>> getYonghu();
    int updateUserState(Users users);
    int deleteUser(String user_id);
}
