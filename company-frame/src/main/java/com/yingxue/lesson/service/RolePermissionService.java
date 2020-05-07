package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.req.RolePermissionOperationReqVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 角色权限相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/20
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface RolePermissionService {
    void addRolePermission(RolePermissionOperationReqVO vo);

    List<String> getRoleIdsByPermissionId(String permissionId);

    int removeByPermissionId(String permissionId);

    List<String> getPermissionIdsByRoleId(String roleId);

    int removeByRoleId(String roleId);

    List<String> getPermissionIdsByRoleIds(List<String> roleIds);
}
