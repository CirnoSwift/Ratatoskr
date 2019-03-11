package com.ratatoskr.battlegugu.dao;

import com.ratatoskr.battlegugu.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserDao {

    // 返回所有用户列表
    List<User> queryUser();
    // 根据id返回对应用户
    User queryUserById(int uid);
    // 根据用户名返回返回用户
    User queryUserByName(String username);
    // 提交用户状态更新
    int updateUser(User user);
    // 注册用户
    int insertUser(User user);
    // 删除用户,该方法应在adminDao中
    //int deleteUserById(int uid);
}
