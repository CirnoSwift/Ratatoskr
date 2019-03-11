package com.ratatoskr.battlegugu.service.impl;

import com.ratatoskr.battlegugu.dao.BattleDao;
import com.ratatoskr.battlegugu.entity.Battle;
import com.ratatoskr.battlegugu.service.BattleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class BattleServiceImpl implements BattleService {


    @Resource
    private BattleDao battleDao;
    @Override
    public List<Battle> queryGuGuList(Date battleDate, Integer status) {
        return battleDao.queryGuGuList(battleDate,status);
    }

    @Override
    @Transactional
    public Boolean insertBattle(Battle battle) {
        if (battle!=null){
            try {
                int effectedNum = battleDao.insertBattle(battle);
                if (effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("插入团战信息失败！");
                }
            }catch(Exception e){
                throw new RuntimeException("插入团战信息失败："+ e.getMessage());
            }
        }else{
            throw new RuntimeException("团战信息为空！");
        }
    }
}
