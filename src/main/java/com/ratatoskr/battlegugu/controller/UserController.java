package com.ratatoskr.battlegugu.controller;


import com.ratatoskr.battlegugu.entity.Battle;
import com.ratatoskr.battlegugu.entity.User;
import com.ratatoskr.battlegugu.service.BattleService;
import com.ratatoskr.battlegugu.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;
    private BattleService battleService;

    /*
       listUser接口用于列出所有用户
     */
    @RequestMapping(value = "listuser",method = RequestMethod.GET)
    private Map<String,Object> listUser(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<User> list = userService.showAllUsers();
        modelMap.put("userList",list);
        return modelMap;
    }

    /*
        用于前端从后台获取所需用户信息
     */
    @RequestMapping(value = "queryuserbyid",method = RequestMethod.GET)
    private Map<String,Object> queryUserById(Integer uid){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        User user = userService.getUserById(uid);
        modelMap.put("user",user);
        return modelMap;
    }

    /*
        用于登录，不确定是否会用到，后续整合shiro可丢弃该接口
        为了减少前端的步骤，将login的check放在cotroller中直接进行
        所以需在userService.getUserByName后接验证方法
        该方法因为要获取前端用户的密码交给后台验证，为了安全考虑防止别人拦截，需要将method改为post，这里为了方便就直接用get
     */
    @RequestMapping(value = "logincheck",method = RequestMethod.GET)
    private Map<String,Object> logincheck(String username,String password){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        User user = userService.getUserByName(username);
        if (user==null){
            modelMap.put("success",false);
            modelMap.put("msg","该用户不存在！");
        }else if (!user.getPassword().equals(password)){
            modelMap.put("success",false);
            modelMap.put("msg","未输入正确的用户名或密码！");
        }else{
            modelMap.put("success",true);
            modelMap.put("msg","登录成功！");
            modelMap.put("uid",user.getUid());
        }
        return modelMap;
    }

    /*
        用于更新修改用户
     */

    @RequestMapping(value = "modifyuser",method = RequestMethod.POST)
    private Map<String,Object> modifyUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Boolean res = userService.modifyUser(user);
        modelMap.put("success",res);
        return modelMap;
    }

    /*
        专门用于打卡
     */
    @RequestMapping(value = "clockon",method = RequestMethod.GET)
    private Map<String,Object> clockon(Integer uid){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        User user = userService.getUserById(uid);
        user.setStatus(0);
        Boolean res = userService.modifyUser(user);
        modelMap.put("success",res);
        return modelMap;
    }

    /*
       用于增加用户，注册
     */
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    private Map<String,Object> addUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Boolean res = userService.addUser(user);
        modelMap.put("success",res);
        return modelMap;
    }

    /*
        用于用户提交请假申请
     */
    @RequestMapping(value = "leaveup",method = RequestMethod.POST)
    private Map<String,Object> leaveUp(Integer uid,String leaveDesc){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Battle battle = new Battle();
        User user = userService.getUserById(uid);
        battle.setUid(uid);
        battle.setBattleDate(new Date());
        battle.setJoin(false);
        battle.setLeaveDesc(leaveDesc);
        Boolean res = battleService.insertBattle(battle);
        modelMap.put("success",res);
        //成功提交打卡后修改对应用户状态
        if(res = true){
            user.setStatus(-1);
            userService.modifyUser(user);
        }
        return modelMap;
    }
}
