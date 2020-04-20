package com.yingxue.lesson.service.impl;

import com.github.pagehelper.PageHelper;
import com.yingxue.lesson.entity.SysRole;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.mapper.SysRoleMapper;
import com.yingxue.lesson.service.RolePermissionService;
import com.yingxue.lesson.service.RoleService;
import com.yingxue.lesson.utils.PageUtil;
import com.yingxue.lesson.vo.req.AddRoleReqVO;
import com.yingxue.lesson.vo.req.RolePageReqVO;
import com.yingxue.lesson.vo.req.RolePermissionOperationReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/19
 * @Package: com.yingxue.lesson.service.impl
 * @Version: 0.0.1
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private RolePermissionService rolePermissionService;

    @Override
    public PageRespVO<SysRole> pageInfo(RolePageReqVO vo) {
        PageHelper.offsetPage(vo.getPageNum(), vo.getPageSize());
        List<SysRole> sysRoles = sysRoleMapper.selectAll(vo);
        return PageUtil.getPageVO(sysRoles);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRole addRole(AddRoleReqVO vo) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(vo, sysRole);
        sysRole.setId(UUID.randomUUID().toString());
        sysRole.setCreateTime(new Date());
        int i = sysRoleMapper.insertSelective(sysRole);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        if (vo.getPermissions() != null && !vo.getPermissions().isEmpty()) {
            RolePermissionOperationReqVO operationReqVO = new RolePermissionOperationReqVO();
            operationReqVO.setRoleId(sysRole.getId());
            operationReqVO.setPermissionIds(vo.getPermissions());
            rolePermissionService.addRolePermission(operationReqVO);
        }
        return sysRole;
    }
}
