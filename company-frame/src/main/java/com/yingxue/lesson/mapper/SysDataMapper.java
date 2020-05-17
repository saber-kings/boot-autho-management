package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.entity.SysDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDataMapper {
    long countByExample(SysDataExample example);

    int deleteByExample(SysDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysData record);

    int insertSelective(SysData record);

    List<SysData> selectByExample(SysDataExample example);

    SysData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysData record, @Param("example") SysDataExample example);

    int updateByExample(@Param("record") SysData record, @Param("example") SysDataExample example);

    int updateByPrimaryKeySelective(SysData record);

    int updateByPrimaryKey(SysData record);
}