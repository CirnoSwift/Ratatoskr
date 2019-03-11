package com.ratatoskr.battlegugu.service;

import com.ratatoskr.battlegugu.entity.Battle;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BattleService {
    // 获取选定日期的所有鸽子的列表，根据status变换查询条件，多参数时要使用@Param标签标注参数对应实体类的属性，否则xml文件不能正确识别
    List<Battle> queryGuGuList(@Param("battleDate") Date battleDate, @Param("status") Integer status);
    //插入团战信息
    Boolean insertBattle(Battle battle);
}
