package com.yingxue.lesson.controller;

import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.service.DeptService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.DeptAddReqVO;
import com.yingxue.lesson.vo.req.DeptUpdateReqVO;
import com.yingxue.lesson.vo.resp.DeptRespNodeVO;
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
 * TODO: 部门模块相关接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/21
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/api")
@Api(tags = "组织管理-部门管理")
public class DeptController {
    @Resource
    private DeptService deptService;

    @GetMapping("/depts")
    @ApiOperation(value = "查询所有部门数据接口")
    @RequiresPermissions("sys:dept:list")
    @MyLog(title = "组织管理-部门管理", action = "查询所有部门数据接口")
    public DataResult<List<SysDept>> getAllDept() {
        return DataResult.success(deptService.selectAll());
    }

    @GetMapping("/dept/tree")
    @ApiOperation(value = "查询部门树形结构列表接口")
    @RequiresPermissions(value = {"sys:user:update", "sys:user:add", "sys:dept:add", "sys:dept:update"}, logical = Logical.OR)
    @MyLog(title = "组织管理-部门管理", action = "查询部门树形结构列表接口")
    public DataResult<List<DeptRespNodeVO>> getDeptTree(@RequestParam(required = false) String deptId) {
        return DataResult.success(deptService.deptTreeList(deptId));
    }

    @PostMapping("/dept")
    @ApiOperation(value = "新增部门数据接口")
    @RequiresPermissions("sys:dept:add")
    @MyLog(title = "组织管理-部门管理", action = "新增部门数据接口")
    public DataResult<SysDept> addDept(@RequestBody @Valid DeptAddReqVO vo) {
        return DataResult.success(deptService.addDept(vo));
    }

    @PutMapping("/dept")
    @ApiOperation(value = "更新部门数据接口")
    @RequiresPermissions("sys:dept:update")
    @MyLog(title = "组织管理-部门管理", action = "更新部门数据接口")
    public DataResult<SysDept> updateDept(@RequestBody @Valid DeptUpdateReqVO vo) {
        deptService.updateDept(vo);
        return DataResult.success();
    }

    @DeleteMapping("/dept/{id}")
    @ApiOperation(value = "删除部门接口")
    @RequiresPermissions("sys:dept:delete")
    @MyLog(title = "组织管理-部门管理", action = "删除部门接口")
    public DataResult<SysDept> deletedDept(@PathVariable("id") String id) {
        deptService.deletedDept(id);
        return DataResult.success();
    }
}
