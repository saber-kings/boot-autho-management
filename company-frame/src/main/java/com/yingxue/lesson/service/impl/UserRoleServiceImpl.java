package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.entity.SysUserRole;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysUserRoleMapper;
import com.yingxue.lesson.service.UserRoleService;
import com.yingxue.lesson.vo.req.UserOwnRoleReqVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author: Saber污妖王
 * TODO: 用户角色关联业务层实现类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/29
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<String> getRoleIdsByUserId(String userId) {
        return sysUserRoleMapper.getRoleIdsByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserRoleInfo(UserOwnRoleReqVO vo) {
        //删除以前的用户角色关联数据
        sysUserRoleMapper.removeRoleByUserId(vo.getUserId());
        if (vo.getRoleIds() != null && !(vo.getRoleIds().isEmpty())) {
            //插入新赋予的用户角色关联数据
            int i = sysUserRoleMapper.batchInsertUserRole(vo.getRoleIds().stream().map(r -> {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setId(UUID.randomUUID().toString());
                sysUserRole.setUserId(vo.getUserId());
                sysUserRole.setRoleId(r);
                sysUserRole.setCreateTime(new Date());
                return sysUserRole;
            }).collect(Collectors.toList()));
            if (i == 0) {
                throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
            }
        }
    }

    @Override
    public List<String> getUserIdsByRoleIds(List<String> roleIds) {
        return sysUserRoleMapper.getUserIdsByRoleIds(roleIds);
    }

    @Override
    public List<String> getUserIdsByRoleId(String roleId) {
        return sysUserRoleMapper.getUserIdsByRoleId(roleId);
    }

    @Override
    public int removeByRoleId(String roleId) {
        return sysUserRoleMapper.removeByRoleId(roleId);
    }
}
