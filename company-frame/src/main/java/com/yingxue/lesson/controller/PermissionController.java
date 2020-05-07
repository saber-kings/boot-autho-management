package com.yingxue.lesson.controller;

import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.entity.SysPermission;
import com.yingxue.lesson.service.PermissionService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.PermissionAddReqVO;
import com.yingxue.lesson.vo.req.PermissionUpdateReqVO;
import com.yingxue.lesson.vo.resp.PermissionRespNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 菜单权限模块相关接口
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
    @ApiOperation("获取所有的菜单权限数据接口")
    @RequiresPermissions("sys:permission:list")
    @MyLog(title = "组织管理-菜单权限管理", action = "获取所有的菜单权限数据接口")
    public DataResult<List<SysPermission>> getAllPermission() {
        return DataResult.success(permissionService.selectAll());
    }

    @GetMapping("/permission/tree")
    @ApiOperation("菜单权限树接口-只递归查询到菜单")
    @RequiresPermissions(value = {"sys:permission:update", "sys:permission:add"}, logical = Logical.OR)
    @MyLog(title = "组织管理-菜单权限管理", action = "菜单权限树接口-只递归查询到菜单")
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTreeExcBtn() {
        return DataResult.success(permissionService.selectAllMenuByTree());
    }

    @GetMapping("/permission/tree/all")
    @ApiOperation("菜单权限树接口-递归查询所有")
    @RequiresPermissions(value = {"sys:role:update", "sys:role:add"}, logical = Logical.OR)
    @MyLog(title = "组织管理-菜单权限管理", action = "菜单权限树接口-递归查询所有")
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTree() {
        return DataResult.success(permissionService.selectAllTree());
    }

    @PostMapping("/permission")
    @ApiOperation(value = "新增菜单权限接口")
    @RequiresPermissions("sys:permission:add")
    @MyLog(title = "组织管理-菜单权限管理", action = "新增菜单权限接口")
    public DataResult<SysPermission> addPermission(@RequestBody @Valid PermissionAddReqVO vo) {
        return DataResult.success(permissionService.addPermission(vo));
    }

    @PutMapping("/permission")
    @ApiOperation(value = "编辑菜单权限接口")
    @RequiresPermissions("sys:permission:update")
    @MyLog(title = "组织管理-菜单权限管理", action = "编辑菜单权限接口")
    public DataResult<Object> updatePermission(@RequestBody @Valid PermissionUpdateReqVO vo) {
        permissionService.updatePermission(vo);
        return DataResult.success();
    }

    @DeleteMapping("/permission/{permissionId}")
    @ApiOperation(value = "删除菜单权限接口")
    @RequiresPermissions("sys:permission:delete")
    @MyLog(title = "组织管理-菜单权限管理", action = "删除菜单权限接口")
    public DataResult<Object> deletedPermission(@PathVariable("permissionId") String permissionId) {
        permissionService.deletedPermission(permissionId);
        return DataResult.success();
    }
}
