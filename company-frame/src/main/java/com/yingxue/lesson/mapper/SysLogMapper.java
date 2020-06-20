package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysLog;
import com.yingxue.lesson.vo.req.SysLogPageReqVO;

import java.util.List;

/**
 * 日志相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysLogMapper {
    /**
     * 根据ID删除日志
     *
     * @param id 日志ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入日志，这里是插入所有字段
     *
     * @param record 日志实体
     * @return 插入的日志
     */
    int insert(SysLog record);

    /**
     * 插入日志，这里是插入所有不为空的字段
     *
     * @param record 日志实体
     * @return 插入的日志
     */
    int insertSelective(SysLog record);

    /**
     * 根据ID查询日志
     *
     * @param id 日志ID
     * @return 查询到的日志
     */
    SysLog selectByPrimaryKey(String id);

    /**
     * 根据日志ID更改对应日志，这里是更改不为空的字段
     *
     * @param record 日志实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysLog record);

    /**
     * 根据日志ID更改对应日志，这里是更改所有字段
     *
     * @param record 日志实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysLog record);

    /**
     * 分页查询日志
     *
     * @param vo 分页查询参数封装VO
     * @return 日志集合
     */
    List<SysLog> selectAll(SysLogPageReqVO vo);

    /**
     * 根据日志ID批量删除日志
     *
     * @param logIds 日志ID集合
     * @return 删除的行数
     */
    int batchDeletedLog(List<String> logIds);
}