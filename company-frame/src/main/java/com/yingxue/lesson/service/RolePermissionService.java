package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.req.RolePermissionOperationReqVO;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 角色权限相关业务接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/20
 * @package com.yingxue.lesson.service
 */
public interface RolePermissionService {
    /**
     * 添加角色权限关系
     *
     * @param vo 角色权限关联的数据封装VO
     */
    void addRolePermission(RolePermissionOperationReqVO vo);

    /**
     * 根据权限ID查询角色ID集合
     *
     * @param permissionId 权限ID
     * @return 角色ID集合
     */
    List<String> getRoleIdsByPermissionId(String permissionId);

    /**
     * 根据权限ID删除角色权限关系
     *
     * @param permissionId 权限ID
     * @return 删除的行数
     */
    int removeByPermissionId(String permissionId);

    /**
     * 根据角色ID查询权限ID集合
     *
     * @param roleId 角色ID
     * @return 权限ID集合
     */
    List<String> getPermissionIdsByRoleId(String roleId);

    /**
     * 根据角色ID删除角色权限关系
     *
     * @param roleId
     * @return
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
