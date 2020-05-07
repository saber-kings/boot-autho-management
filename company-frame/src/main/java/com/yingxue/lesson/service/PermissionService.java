package com.yingxue.lesson.service;

import com.yingxue.lesson.entity.SysPermission;
import com.yingxue.lesson.vo.req.PermissionAddReqVO;
import com.yingxue.lesson.vo.req.PermissionUpdateReqVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 权限相关业务接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/31
 * @Package: com.yingxue.lesson.service
 * @Version: 0.0.1
 */
public interface PermissionService {
    List<SysPermission> selectAll();

    List<PermissionRespNodeVO> selectAllMenuByTree();

    SysPermission addPermission(PermissionAddReqVO vo);

    List<PermissionRespNodeVO> permissionTreeList(String userId);

    List<PermissionRespNodeVO> selectAllTree();

    void updatePermission(PermissionUpdateReqVO vo);

    void deletedPermission(String permissionId);

    List<String> getPermissionByUserId(String userId);

    List<SysPermission> getPermissionsById(String userId);
}
