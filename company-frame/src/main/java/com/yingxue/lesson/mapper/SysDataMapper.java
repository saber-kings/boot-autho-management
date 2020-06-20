package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.entity.SysDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysDataMapper {
    /**
     * 根据给定参数查询总条数
     *
     * @param example 参数实体
     * @return 总条数
     */
    long countByExample(SysDataExample example);

    /**
     * 根据给定参数删除对应数据字典
     *
     * @param example 参数实体
     * @return 删除的行数
     */
    int deleteByExample(SysDataExample example);

    /**
     * 根据ID删除对应数据字典
     *
     * @param id 数据字典ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据字典，这里是插入所有字段
     *
     * @param record 数据字典实体
     * @return 插入的行数
     */
    int insert(SysData record);

    /**
     * 插入数据字典，这里是插入不为空的所有字段
     *
     * @param record 数据字典实体
     * @return 插入的行数
     */
    int insertSelective(SysData record);

    /**
     * 根据给定参数查询对应数据字典
     *
     * @param example 参数实体
     * @return 查询出的结果集
     */
    List<SysData> selectByExample(SysDataExample example);

    /**
     * 根据数据字典ID删除对应数据字典
     *
     * @param id 数据字典ID
     * @return 查询到的数据字典项
     */
    SysData selectByPrimaryKey(Integer id);

    /**
     * 根据给定参数更改对应数据字典，这里是更改不为空的字段
     *
     * @param record  数据字典实体
     * @param example 参数实体
     * @return 更改的行数
     */
    int updateByExampleSelective(@Param("record") SysData record, @Param("example") SysDataExample example);

    /**
     * 根据给定参数更改对应数据字典，这里是更改所有字段
     *
     * @param record  数据字典实体
     * @param example 参数实体
     * @return 更改的行数
     */
    int updateByExample(@Param("record") SysData record, @Param("example") SysDataExample example);

    /**
     * 根据数据字典ID更改对应数据字典，这里是更改不为空的字段
     *
     * @param record 数据字典实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysData record);

    /**
     * 根据数据字典ID更改对应数据字典，这里是更改所有字段
     *
     * @param record 数据字典实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysData record);
}