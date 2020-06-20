package com.yingxue.lesson.mapper;

import com.yingxue.lesson.entity.SysRolePermission;

import java.util.List;

/**
 * @author Saber污妖王
 */
public interface SysRolePermissionMapper {
    /**
     * 根据ID删除角色权限关系
     *
     * @param id 角色权限关系ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入角色权限关系，这里是插入所有字段
     *
     * @param record 角色权限关系实体
     * @return 插入的角色权限关系
     */
    int insert(SysRolePermission record);

    /**
     * 插入角色权限关系，这里是插入所有不为空的字段
     *
     * @param record 角色权限关系实体
     * @return 插入的角色权限关系
     */
    int insertSelective(SysRolePermission record);

    /**
     * 根据ID查询角色权限关系
     *
     * @param id 角色权限关系ID
     * @return 查询到的角色权限关系
     */
    SysRolePermission selectByPrimaryKey(String id);

    /**
     * 根据角色权限关系ID更改对应角色权限关系，这里是更改不为空的字段
     *
     * @param record 角色权限关系实体
     * @return 更改的行数
     */
    int updateByPrimaryKeySelective(SysRolePermission record);

    /**
     * 根据角色权限关系ID更改对应角色权限关系，这里是更改所有字段
     *
     * @param record 角色权限关系实体
     * @return 更改的行数
     */
    int updateByPrimaryKey(SysRolePermission record);

    /**
     * 批量插入角色权限关系
     *
     * @param list 角色权限关系实体集合
     * @return 插入的行数
     */
    int batchInsertRolePermission(List<SysRolePermission> list);

    /**
     * 根据权限ID查询角色ID
     *
     * @param permissionId 权限ID
     * @return 角色ID集合
     */
    List<String> getRoleIdsByPermissionId(String permissionId);

    /**
     * 根据权限ID删除角色权限关系
     *
     * @param permissionId 权限ID
     * @return 删除行数
     */
    int removeByPermissionId(String permissionId);

    /**
     * 根据角色ID查询权限ID
     *
     * @param roleId 角色ID
     * @return 权限ID集合
     */
    List<String> getPermissionIdsByRoleId(String roleId);

    /**
     * 根据角色ID删除角色权限关系
     *
     * @param roleId 角色ID
     * @return 删除行数
     */
    int removeByRoleId(String roleId);

    /**
     * 根据角色ID集合查询权限ID集合
     *
     * @param roleIds 角色ID集合
     * @return 权限ID集合
     */
    List<String> getPermissionIdsByRoleIds(List<String> roleIds);
}