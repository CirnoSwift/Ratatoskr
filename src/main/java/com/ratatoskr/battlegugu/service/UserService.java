package com.ratatoskr.battlegugu.service;

import com.ratatoskr.battlegugu.entity.User;

import java.util.List;

public interface UserService {

    // 返回所有用户列表
    List<User> showAllUsers();
    // 根据id返回对应用户
    User getUserById(int uid);
    // 根据用户名返回返回用户
    User getUserByName(String username);
    // 提交用户状态更新
    Boolean modifyUser(User user);
    // 注册用户
    Boolean addUser(User user);

}
