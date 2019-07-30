package com.hwadee.rsgl.dao;

import com.hwadee.rsgl.model.English;

public interface EnglishMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(English record);

    int insertSelective(English record);

    English selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(English record);

    int updateByPrimaryKey(English record);
}