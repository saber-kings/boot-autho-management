package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysRotationChart;
import com.yingxue.lesson.vo.req.RotationChartDeleteReqVO;

import java.util.List;

/**
 * 轮播图相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysRotationChartMapper {
    /**
     * 根据ID删除轮播图
     *
     * @param id 轮播图ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入轮播图，这里是插入所有字段
     *
     * @param record 轮播图实体
     * @return 插入的轮播图
     */
    int insert(SysRotationChart record);

    /**
     * 插入轮播图，这里是插入所有不为空的字段
     *
     * @param record 轮播图实体
     * @return 插入的轮播图
     */
    int insertSelective(SysRotationChart record);

    /**
     * 根据ID查询轮播图
     *
     * @param id 轮播图ID
     * @return 查询到的轮播图
     */
    SysRotationChart selectByPrimaryKey(String id);

    /**
     * 根据轮播图ID更改对应轮播图，这里是更改不为空的字段
     *
     * @param record 轮播图实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysRotationChart record);

    /**
     * 根据轮播图ID更改对应轮播图，这里是更改所有字段
     *
     * @param record 轮播图实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysRotationChart record);

    /**
     * 查询所有轮播图
     *
     * @return 轮播图集合
     */
    List<SysRotationChart> selectAll();

    /**
     * 根据轮播图ID批量删除轮播图
     *
     * @param list 轮播图ID和轮播图文件地址，两个参数的封装实体集合
     * @return 删除的行数
     */
    int batchDeleteRotation(List<RotationChartDeleteReqVO> list);

    /**
     * 根据用户ID查询所有轮播图信息
     *
     * @param userId 用户ID
     * @return 轮播图信息实体集合
     */
    List<SysRotationChart> selectByUserId(String userId);
}