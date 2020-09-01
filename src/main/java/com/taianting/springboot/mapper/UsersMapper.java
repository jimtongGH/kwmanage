package com.taianting.springboot.mapper;

import com.taianting.springboot.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UsersMapper {
    //通过login_username查找user
    Map<String,String> findUsersByLUN(String login_username);

    //通过user_id查找user
    Map<String,String> findUsersByUserId(String user_id);

    //查找userid和username
    List<Map<String,String>> findUserIdAndName();

    //注册,添加用户
    int addUsers(Users users);

    //更新用户信息
    int updateUsersInfo(Users users);

    //更改密码
    int updateUsersPassword(Users users);

    //查找所有未验证用户
    List<Map<String,String>> getSignupUser();

    //将未验证用户变为用户
    int updateSignupUser(@Param("user_id") String user_id);

    //获取所有用户信息
    List<Map<String,String>> getYonghu();

    //修改用户状态
    int updateUserState(Users users);

    //软删除用户
    int deleteUser(String user_id);
}
