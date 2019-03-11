package com.ratatoskr.battlegugu.dao;

import com.ratatoskr.battlegugu.entity.Battle;
import com.ratatoskr.battlegugu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Date;
import java.util.List;

@Mapper
public interface BattleDao {

    // 获取选定日期的所有鸽子的列表，根据status变换查询条件
    List<Battle> queryGuGuList(@Param("battleDate") Date battleDate, @Param("status") Integer status);
    //插入团战信息
    int insertBattle(Battle battle);

}
