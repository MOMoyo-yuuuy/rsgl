package com.hwadee.rsgl.dao;

import com.hwadee.rsgl.model.Math;

public interface MathMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Math record);

    int insertSelective(Math record);

    Math selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Math record);

    int updateByPrimaryKey(Math record);
}