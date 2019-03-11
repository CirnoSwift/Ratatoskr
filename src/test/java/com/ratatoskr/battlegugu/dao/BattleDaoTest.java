package com.ratatoskr.battlegugu.dao;

import com.ratatoskr.battlegugu.entity.Battle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BattleDaoTest {

    @Resource
    private BattleDao battleDao;

    @Test
    public void queryGuGuList() throws Exception{

        Date battleDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        battleDate = sdf.parse("2019-1-26");
        List<Battle> battleList = battleDao.queryGuGuList(battleDate,1);
        assertEquals(2,battleList.size());

    }

    @Test
    public void insertBattle() throws Exception{
        Date battleDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        battleDate = sdf.parse("2019-1-26");
        Battle battle = new Battle();
        battle.setUid(2046589);
        battle.setBattleDate(battleDate);
        battle.setJoin(false);
        int effectedNum = battleDao.insertBattle(battle);
        assertEquals(1,effectedNum);

    }
}