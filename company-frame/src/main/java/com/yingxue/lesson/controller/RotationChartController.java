package com.yingxue.lesson.controller;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysRotationChart;
import com.yingxue.lesson.service.RotationChartService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.utils.JwtTokenUtil;
import com.yingxue.lesson.vo.req.RotationChartDeleteReqVO;
import com.yingxue.lesson.vo.req.RotationChartReqAddVO;
import com.yingxue.lesson.vo.req.RotationChartUpdateReqVO;
import com.yingxue.lesson.vo.req.RotationPageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 轮播图模块相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/10
 * @package com.yingxue.lesson.controller
 */
@RestController
@RequestMapping("/api")
@Api(tags = "文件系统-轮播图管理")
public class RotationChartController {
    @Resource
    private RotationChartService rotationChartService;

    @PostMapping("/rotations")
    @ApiOperation("分页获取轮播图信息接口")
    @RequiresPermissions("sys:rotation:list")
    public DataResult<PageRespVO<SysRotationChart>> pageInfo(@RequestBody RotationPageReqVO vo) {
        return DataResult.success(rotationChartService.pageInfo(vo));
    }

    @PostMapping("/rotation")
    @ApiOperation("新增轮播图接口")
    @RequiresPermissions("sys:rotation:add")
    public DataResult<Object> addRotation(@RequestBody @Valid RotationChartReqAddVO vo, HttpServletRequest request) {
        String userId = JwtTokenUtil.getUserId(request.getHeader(Constant.ACCESS_TOKEN));
        rotationChartService.addRotationChart(vo, userId);
        return DataResult.success();
    }

    @PutMapping("/rotation")
    @ApiOperation("编辑轮播图接口")
    @RequiresPermissions("sys:rotation:update")
    public DataResult<Object> updateRotation(@RequestBody @Valid RotationChartUpdateReqVO vo, HttpServletRequest request) {
        String userId = JwtTokenUtil.getUserId(request.getHeader(Constant.ACCESS_TOKEN));
        rotationChartService.updateRotationChart(vo, userId);
        return DataResult.success();
    }

    @DeleteMapping("/rotation")
    @ApiOperation("删除轮播图接口")
    @RequiresPermissions("sys:rotation:delete")
    public DataResult<Object> deleteRotation(@RequestBody @Valid List<RotationChartDeleteReqVO> list) {
        rotationChartService.batchDeleteRotation(list);
        return DataResult.success();
    }

    @GetMapping("/rotations")
    @ApiOperation("查询所有轮播图即在前端展现轮播图的接口")
    public DataResult<List<SysRotationChart>> selectAll() {
        return DataResult.success(rotationChartService.selectAll());
    }
}
