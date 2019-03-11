package com.ratatoskr.battlegugu.service.impl;

import com.ratatoskr.battlegugu.dao.UserDao;
import com.ratatoskr.battlegugu.entity.User;
import com.ratatoskr.battlegugu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public List<User> showAllUsers() {
        return userDao.queryUser();
    }

    @Override
    public User getUserById(int uid) {
        return userDao.queryUserById(uid);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.queryUserByName(username);
    }

    /*
    涉及修改底层数据库时启用事务控制
     */
    @Override
    @Transactional
    public Boolean modifyUser(User user) {

        if (user.getUid()!=null && user.getUid()>0){
            try {
                int effectedNum = userDao.updateUser(user);
                if (effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("更新用户信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("更新用户信息失败" + e.toString());
            }
        }else{
            throw new RuntimeException("用户id不能为空！");
        }
    }

    @Override
    @Transactional
    public Boolean addUser(User user) {

        if (user.getUid()!=null && user.getUid()>0){
            try {
                int effectedNum = userDao.insertUser(user);
                if (effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("插入用户信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("插入用户信息失败" + e.toString());
            }
        }else{
            throw new RuntimeException("用户id不能为空！");
        }

    }
}
