package com.hwadee.rsgl.dao;

import com.hwadee.rsgl.model.Coding;

public interface CodingMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Coding record);

    int insertSelective(Coding record);

    Coding selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Coding record);

    int updateByPrimaryKey(Coding record);
}