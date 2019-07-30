package com.hwadee.rsgl.dao;

import com.hwadee.rsgl.model.Chinese;

public interface ChineseMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Chinese record);

    int insertSelective(Chinese record);

    Chinese selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Chinese record);

    int updateByPrimaryKey(Chinese record);
}