package com.yingxue.lesson.controller;

import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.service.DataService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.DataAddReqVO;
import com.yingxue.lesson.vo.req.DataPageReqVO;
import com.yingxue.lesson.vo.req.DataUpdateReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/5
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
@Api(tags = "系统管理-字典管理")
public class DataController {
    @Resource
    private DataService dataService;

    @PostMapping("/datas")
    @ApiOperation(value = "分页查询数据字典接口")
//    @RequiresPermissions("sys:data:list")
    @MyLog(title = "系统管理-字典管理", action = "分页查询数据字典接口")
    public DataResult<PageRespVO<SysData>> pageInfo(@RequestBody DataPageReqVO vo) {
        return DataResult.success(dataService.pageInfo(vo));
    }

    @PostMapping("/data")
    @ApiOperation(value = "新增字典接口")
//    @RequiresPermissions("sys:data:add")
    @MyLog(title = "组织模块-字典管理", action = "新增数据字典接口")
    public DataResult<Object> addData(@RequestBody @Valid DataAddReqVO vo) {
        DataResult<Object> result = DataResult.success();
        dataService.addData(vo);
        return result;
    }

    @PutMapping("/data")
    @ApiOperation(value = "列表修改字典信息接口")
//    @RequiresPermissions("sys:data:update")
    @MyLog(title = "组织模块-字典管理", action = "列表修改字典信息接口")
    public DataResult<Object> updateDataInfo(@RequestBody @Valid DataUpdateReqVO vo, HttpServletRequest request) {
        dataService.updateData(vo);
        return DataResult.success();
    }
    @DeleteMapping("/data")
    @ApiOperation(value = "批量/删除字典接口")
//    @RequiresPermissions("sys:data:delete")
    @MyLog(title = "组织模块-字典管理", action = "批量/删除字典接口")
    public DataResult<Object> deletedDatas(@RequestBody @ApiParam("字典id集合") List<String> list){
        dataService.batchDeletedData(list);
        return DataResult.success();
    }
}
