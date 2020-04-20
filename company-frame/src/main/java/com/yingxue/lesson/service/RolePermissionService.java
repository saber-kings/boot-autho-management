package com.yingxue.lesson.service;

import com.yingxue.lesson.vo.req.RolePermissionOperationReqVO;

/**
 * @Author: Saber污妖王
 * TODO: 角色权限关联业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/20
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface RolePermissionService {
    void addRolePermission(RolePermissionOperationReqVO vo);
}
