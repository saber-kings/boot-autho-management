package com.yingxue.lesson.controller;

import com.yingxue.lesson.entity.SysRole;
import com.yingxue.lesson.service.RoleService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.AddRoleReqVO;
import com.yingxue.lesson.vo.req.RolePageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author: Saber污妖王
 * TODO: 角色模块接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/19
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/api")
@Api(tags = "组织管理-角色管理")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping("/roles")
    @ApiOperation(value = "分页获取角色数据")
    private DataResult<PageRespVO<SysRole>> pageInfo(@RequestBody RolePageReqVO vo){
        return DataResult.success(roleService.pageInfo(vo));
    }

    @PostMapping("/role")
    @ApiOperation(value = "新增角色接口")
    private DataResult<SysRole> addRole(@RequestBody @Valid AddRoleReqVO vo){
        return DataResult.success(roleService.addRole(vo));
    }
}
