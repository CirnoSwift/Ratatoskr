package com.ratatoskr.battlegugu.dao;

import com.ratatoskr.battlegugu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Resource
    private UserDao userDao;


    @Test
    public void queryUser() {
        List<User> userList = userDao.queryUser();
        assertEquals(1,userList.size());
    }

    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(202718);
        assertEquals("乡村野团琪露诺",user.getNickname());
    }

    @Test
    public void queryUserByName() {
        User user = userDao.queryUserByName("cirno");
        assertEquals("乡村野团琪露诺",user.getNickname());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUid(256498);
        user.setNickname("桥驿听雨落");
        user.setUsername("rbqyuluo");
        user.setPassword("password");
        user.setStatus(1);
        int effectedNum = userDao.updateUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUid(256498);
        user.setNickname("桥驿听雨落");
        user.setUsername("rbqyuluo");
        user.setPassword("password");
        user.setStatus(-1);
        int effectedNum = userDao.insertUser(user);
        assertEquals(1,effectedNum);
    }
}