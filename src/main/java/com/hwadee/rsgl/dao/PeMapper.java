package com.hwadee.rsgl.dao;

import com.hwadee.rsgl.model.Pe;

public interface PeMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Pe record);

    int insertSelective(Pe record);

    Pe selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Pe record);

    int updateByPrimaryKey(Pe record);
}