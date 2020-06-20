package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysRole;
import com.yingxue.lesson.vo.req.RolePageReqVO;

import java.util.List;

/**
 * 角色相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysRoleMapper {
    /**
     * 根据ID删除角色
     *
     * @param id 角色ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入角色，这里是插入所有字段
     *
     * @param record 角色实体
     * @return 插入的角色
     */
    int insert(SysRole record);

    /**
     * 插入角色，这里是插入所有不为空的字段
     *
     * @param record 角色实体
     * @return 插入的角色
     */
    int insertSelective(SysRole record);

    /**
     * 根据ID查询角色
     *
     * @param id 角色ID
     * @return 查询到的角色
     */
    SysRole selectByPrimaryKey(String id);

    /**
     * 根据角色ID更改对应角色，这里是更改不为空的字段
     *
     * @param record 角色实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * 根据角色ID更改对应角色，这里是更改所有字段
     *
     * @param record 角色实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysRole record);

    /**
     * 分页查询角色
     *
     * @param vo 分页查询参数封装VO
     * @return 角色集合
     */
    List<SysRole> selectAll(RolePageReqVO vo);

    /**
     * 根据ID查询角色名称
     *
     * @param ids ID集合
     * @return 角色名称集合
     */
    List<String> selectNamesByIds(List<String> ids);
}