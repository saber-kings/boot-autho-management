package com.yingxue.lesson.controller;

import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.entity.SysRole;
import com.yingxue.lesson.service.RoleService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.RoleAddReqVO;
import com.yingxue.lesson.vo.req.RolePageReqVO;
import com.yingxue.lesson.vo.req.RoleUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Saber污妖王
 * TODO: 角色模块相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/19
 * @package com.yingxue.lesson.controller
 */
@RestController
@RequestMapping("/api")
@Api(tags = "组织管理-角色管理")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping("/roles")
    @ApiOperation(value = "分页获取角色数据接口")
    @RequiresPermissions("sys:role:list")
    @MyLog(title = "组织管理-角色管理", action = "分页获取角色数据接口")
    public DataResult<PageRespVO<SysRole>> pageInfo(@RequestBody RolePageReqVO vo) {
        return DataResult.success(roleService.pageInfo(vo));
    }

    @PostMapping("/role")
    @ApiOperation(value = "新增角色接口")
    @RequiresPermissions("sys:role:add")
    @MyLog(title = "组织管理-角色管理", action = "新增角色接口")
    public DataResult<SysRole> addRole(@RequestBody @Valid RoleAddReqVO vo) {
        return DataResult.success(roleService.addRole(vo));
    }

    @GetMapping("/role/{id}")
    @ApiOperation(value = "获取角色详情接口")
    @RequiresPermissions("sys:role:detail")
    @MyLog(title = "组织管理-角色管理", action = "获取角色详情接口")
    public DataResult<SysRole> detailInfo(@PathVariable("id") String id) {
        return DataResult.success(roleService.detailInfo(id));
    }

    @PutMapping("/role")
    @ApiOperation(value = "更新角色信息接口")
    @RequiresPermissions("sys:role:update")
    @MyLog(title = "组织管理-角色管理", action = "更新角色信息接口")
    public DataResult<Object> updateRole(@RequestBody @Valid RoleUpdateReqVO vo) {
        DataResult<Object> result = DataResult.success();
        roleService.updateRole(vo);
        return result;
    }

    @DeleteMapping("/role/{id}")
    @ApiOperation(value = "删除角色接口")
    @RequiresPermissions("sys:role:delete")
    @MyLog(title = "组织管理-角色管理", action = "删除角色接口")
    public DataResult<Object> deletedRole(@PathVariable("id") String id) {
        roleService.deletedRole(id);
        return DataResult.success();
    }
}
