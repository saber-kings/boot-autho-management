package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysRolePermission;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysRolePermissionMapper;
import com.yingxue.lesson.service.RolePermissionService;
import com.yingxue.lesson.vo.req.RolePermissionOperationReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Saber污妖王
 * TODO: 角色权限关联业务层实现类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/20
 * @package com.yingxue.lesson.service.impl
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public void addRolePermission(RolePermissionOperationReqVO vo) {
        sysRolePermissionMapper.removeByRoleId(vo.getRoleId());
        if (vo.getPermissionIds() != null && !vo.getPermissionIds().isEmpty()) {
            List<SysRolePermission> list = vo.getPermissionIds().stream().map(permissionId -> {
                SysRolePermission sysRolePermission = new SysRolePermission();
                sysRolePermission.setId(UUID.randomUUID().toString());
                sysRolePermission.setCreateTime(new Date());
                sysRolePermission.setRoleId(vo.getRoleId());
                sysRolePermission.setPermissionId(permissionId);
                return sysRolePermission;
            }).collect(Collectors.toList());

            int i = sysRolePermissionMapper.batchInsertRolePermission(list);
            if (i == 0) {
                throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
            }
        }
    }

    @Override
    public List<String> getRoleIdsByPermissionId(String permissionId) {
        return sysRolePermissionMapper.getRoleIdsByPermissionId(permissionId);
    }

    @Override
    public int removeByPermissionId(String permissionId) {
        return sysRolePermissionMapper.removeByPermissionId(permissionId);
    }

    @Override
    public List<String> getPermissionIdsByRoleId(String roleId) {
        return sysRolePermissionMapper.getPermissionIdsByRoleId(roleId);
    }

    @Override
    public int removeByRoleId(String roleId) {
        return sysRolePermissionMapper.removeByRoleId(roleId);
    }

    @Override
    public List<String> getPermissionIdsByRoleIds(List<String> roleIds) {
        return sysRolePermissionMapper.getPermissionIdsByRoleIds(roleIds);
    }
}
