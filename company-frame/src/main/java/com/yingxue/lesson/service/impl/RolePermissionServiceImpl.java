package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysRolePermission;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysRolePermissionMapper;
import com.yingxue.lesson.service.RolePermissionService;
import com.yingxue.lesson.vo.req.RolePermissionOperationReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/20
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public void addRolePermission(RolePermissionOperationReqVO vo) {
        if (vo.getPermissionIds()!=null&&!vo.getPermissionIds().isEmpty()) {
            List<SysRolePermission> list = vo.getPermissionIds().stream().map(permissionId -> {
                SysRolePermission sysRolePermission = new SysRolePermission();
                sysRolePermission.setId(UUID.randomUUID().toString());
                sysRolePermission.setCreateTime(new Date());
                sysRolePermission.setRoleId(vo.getRoleId());
                sysRolePermission.setPermissionId(permissionId);
                return sysRolePermission;
            }).collect(Collectors.toList());

            int i = sysRolePermissionMapper.batchInsertRolePermission(list);
            if (i==0) {
                throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
            }
        }
    }
}
