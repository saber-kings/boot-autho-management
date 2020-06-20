package com.yingxue.lesson.controller;

import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.entity.SysLog;
import com.yingxue.lesson.service.LogService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.SysLogPageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 日志模块相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/5/1
 * @package com.yingxue.lesson.controller
 */
@RestController
@RequestMapping("/api")
@Api(tags = "系统管理-日志管理")
public class LogController {
    @Resource
    private LogService logService;

    @PostMapping("/logs")
    @ApiOperation(value = "分页查找操作日志接口")
    @RequiresPermissions("sys:log:list")
    public DataResult<PageRespVO<SysLog>> pageInfo(@RequestBody SysLogPageReqVO vo) {
        return DataResult.success(logService.pageInfo(vo));
    }

    @DeleteMapping("/log")
    @ApiOperation(value = "删除日志接口")
    @RequiresPermissions("sys:log:delete")
    @MyLog(title = "系统管理-日志管理", action = "删除日志接口")
    public DataResult<Object> deletedLog(@RequestBody @ApiParam(value = "日志 id 集合") List<String> logIds) {
        logService.deletedLog(logIds);
        return DataResult.success();
    }
}
