package com.yingxue.lesson.controller;

import com.yingxue.lesson.entity.SysDept;
import com.yingxue.lesson.service.DeptService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.AddDeptReqVO;
import com.yingxue.lesson.vo.resp.DeptRespNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.yingxue.lesson.utils.DataResult.success;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
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
    public DataResult<List<SysDept>> getAllDept(){
        return success(deptService.selectAll());
    }

    @GetMapping("/dept/tree")
    @ApiOperation(value = "查询所有部门数据接口")
    public DataResult<List<DeptRespNodeVO>> getDeptTree(){
        return success(deptService.deptTreeList());
    }

    @PostMapping("/dept")
    @ApiOperation(value = "新增部门数据接口")
    public DataResult<SysDept> addDept(@RequestBody @Valid AddDeptReqVO vo){
        return success(deptService.addDept(vo));
    }
}
