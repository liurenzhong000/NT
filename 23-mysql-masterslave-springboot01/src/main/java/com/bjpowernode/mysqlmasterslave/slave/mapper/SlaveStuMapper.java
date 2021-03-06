package com.bjpowernode.mysqlmasterslave.slave.mapper;

import com.bjpowernode.mysqlmasterslave.model.Stu;

import java.util.List;

public interface SlaveStuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Stu record);

    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);

    List<Stu> selectAll();
}