package com.hwadee.rsgl.dao;

import java.util.List;

import com.hwadee.rsgl.model.PositionChage;

public interface PositionChageMapper {
    int deleteByPrimaryKey(Integer number);

    int insert(PositionChage record);

    int insertSelective(PositionChage record);

    PositionChage selectByPrimaryKey(Integer number);

    int updateByPrimaryKeySelective(PositionChage record);

    int updateByPrimaryKey(PositionChage record);
    
    List<PositionChage> selectAll();
}