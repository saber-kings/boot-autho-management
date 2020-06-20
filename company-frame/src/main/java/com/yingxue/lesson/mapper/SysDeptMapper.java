package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 部门相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysDeptMapper {
    /**
     * 根据ID删除部门
     *
     * @param id 部门ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入部门，这里是插入所有字段
     *
     * @param record 部门实体
     * @return 插入的行数
     */
    int insert(SysDept record);

    /**
     * 插入部门，这里是插入不为空的所有字段
     *
     * @param record 部门实体
     * @return 插入的行数
     */
    int insertSelective(SysDept record);

    /**
     * 根据ID查询部门
     *
     * @param id 部门ID
     * @return 查询到的部门
     */
    SysDept selectByPrimaryKey(String id);

    /**
     * 根据部门ID更改对应部门，这里是更改不为空的字段
     *
     * @param record 部门实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysDept record);

    /**
     * 根据部门ID更改对应部门，这里是更改所有字段
     *
     * @param record 部门实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysDept record);

    /**
     * 查询所有部门
     *
     * @return 部门实体集合
     */
    List<SysDept> selectAll();

    /**
     * 维护新的层级关系（规则：父级关系编码+自己的编码）
     *
     * @param oldStr       旧的父级关系编码
     * @param newStr       新的层级关系编码
     * @param relationCode 关系编码
     * @return 修改的行数
     */
    int updateRelationCode(@Param("oldStr") String oldStr,
                           @Param("newStr") String newStr,
                           @Param("relationCode") String relationCode);

    /**
     * 根据关系编码查询子级部门ID
     *
     * @param relationCode 关系编码
     * @return 子级部门ID集合
     */
    List<String> selectChildIds(String relationCode);

    /**
     * 根据ID集合删除部门（逻辑删除）
     *
     * @param updateTime 修改时间
     * @param list       ID集合
     * @return 删除的行数
     */
    int deletedDepts(@Param("updateTime") Date updateTime,
                     @Param("list") List<String> list);
}