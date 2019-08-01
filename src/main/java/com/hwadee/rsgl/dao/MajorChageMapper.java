package com.hwadee.rsgl.dao;

import java.util.List;

import com.hwadee.rsgl.model.MajorChage;

public interface MajorChageMapper {
    int deleteByPrimaryKey(Integer number);

    int insert(MajorChage record);

    int insertSelective(MajorChage record);

    MajorChage selectByPrimaryKey(Integer number);

    int updateByPrimaryKeySelective(MajorChage record);

    int updateByPrimaryKey(MajorChage record);
    
    List<MajorChage> selectAll();
}