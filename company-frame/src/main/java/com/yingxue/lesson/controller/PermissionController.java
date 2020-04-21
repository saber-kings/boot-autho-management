package com.yingxue.lesson.controller;

import com.yingxue.lesson.entity.SysPermission;
import com.yingxue.lesson.service.PermissionService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.PermissionAddReqVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/31
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/api")
@Api(tags = "组织管理-菜单权限管理")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @GetMapping("/permissions")
    @ApiOperation("获取所有的菜单权限数据")
    public DataResult<List<SysPermission>> getAllPermission(){
        return DataResult.success(permissionService.selectAll());
    }

    @GetMapping("/permission/tree")
    @ApiOperation("菜单权限树接口-只递归查询到菜单")
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTreeExcBtn(){
        return DataResult.success(permissionService.selectAllMenuByTree());
    }

    @GetMapping("/permission/tree/all")
    @ApiOperation("菜单权限树接口-递归查询所有")
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTree(){
        return DataResult.success(permissionService.selectAllTree());
    }

    @PostMapping("/permission")
    @ApiOperation(value = "新增菜单权限接口")
    public DataResult<SysPermission> addPermission(@RequestBody @Valid PermissionAddReqVO vo){
        return DataResult.success(permissionService.addPermission(vo));
    }
}
