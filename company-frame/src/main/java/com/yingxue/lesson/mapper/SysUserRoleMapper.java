package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysUserRole;

import java.util.List;

/**
 * 用户角色关系相关数据访问层接口
 *
 * @author Saber污妖王
 */
public interface SysUserRoleMapper {
    /**
     * 根据ID删除用户角色关系
     *
     * @param id 用户角色关系ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入用户角色关系，这里是插入所有字段
     *
     * @param record 用户角色关系实体
     * @return 插入的用户角色关系
     */
    int insert(SysUserRole record);

    /**
     * 插入用户角色关系，这里是插入所有不为空的字段
     *
     * @param record 用户角色关系实体
     * @return 插入的用户角色关系
     */
    int insertSelective(SysUserRole record);

    /**
     * 根据ID查询用户角色关系
     *
     * @param id 用户角色关系ID
     * @return 查询到的用户角色关系
     */
    SysUserRole selectByPrimaryKey(String id);

    /**
     * 根据用户角色关系ID更改对应用户角色关系，这里是更改不为空的字段
     *
     * @param record 用户角色关系实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     * 根据用户角色关系ID更改对应用户角色关系，这里是更改所有字段
     *
     * @param record 用户角色关系实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysUserRole record);

    /**
     * 根据用户ID查询角色ID集合
     *
     * @param userId 用户ID
     * @return 角色ID集合
     */
    List<String> getRoleIdsByUserId(String userId);

    /**
     * 根据用户ID移除用户角色关系
     *
     * @param userId 用户ID
     * @return 移删除的行数
     */
    int removeRoleByUserId(String userId);

    /**
     * 批量插入用户角色关系
     *
     * @param list 用户角色关系实体
     * @return 插入的行数
     */
    int batchInsertUserRole(List<SysUserRole> list);

    /**
     * 根据角色ID集合查询用户ID集合
     *
     * @param roleIds 角色ID集合
     * @return 用户ID集合
     */
    List<String> getUserIdsByRoleIds(List<String> roleIds);

    /**
     * 根据角色ID查询用户ID集合
     *
     * @param roleId 角色ID
     * @return 用户ID集合
     */
    List<String> getUserIdsByRoleId(String roleId);

    /**
     * 根据角色ID移除用户角色关系
     *
     * @param roleId 角色ID
     * @return 移删除的行数
     */
    int removeByRoleId(String roleId);
}