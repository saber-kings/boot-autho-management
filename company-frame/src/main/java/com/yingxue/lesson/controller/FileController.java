package com.yingxue.lesson.controller;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysFile;
import com.yingxue.lesson.service.FileService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.utils.JwtTokenUtil;
import com.yingxue.lesson.vo.req.FilePageReqVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 文件模块相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/9
 * @package com.yingxue.lesson.controller
 */
@RestController
@RequestMapping("/api")
@Api(tags = "文件系统-我的文件")
public class FileController {
    @Resource
    private FileService fileService;

    @PostMapping("/file")
    @ApiOperation("文件上传接口")
    public DataResult<Object> upload(@RequestParam MultipartFile file, HttpServletRequest request) {
        String userId = JwtTokenUtil.getUserId(request.getHeader(Constant.ACCESS_TOKEN));
        int type = request.getIntHeader(Constant.FILE_TYPE);
        return DataResult.success(fileService.upload(file, userId, type));
    }

    @GetMapping("/file/{fileId}")
    @ApiOperation(value = "文件下载接口", produces = "application/octet-stream")
    public void download(@PathVariable String fileId, HttpServletRequest request, HttpServletResponse response) {
        fileService.download(fileId, request, response);
    }

    @PostMapping("/files")
    @ApiOperation("分页获取当前用户的文件接口")
    public DataResult<PageRespVO<SysFile>> pageInfo(@RequestBody FilePageReqVO vo, HttpServletRequest request) {
        String userId = JwtTokenUtil.getUserId(request.getHeader(Constant.ACCESS_TOKEN));
        return DataResult.success(fileService.pageInfo(vo, userId));
    }

    @DeleteMapping("/file")
    @ApiOperation("批量/删除文件接口")
    public DataResult<Object> deleteFile(@RequestBody @ApiParam("文件名称集合") List<String> list, HttpServletRequest request) {
        String userId = JwtTokenUtil.getUserId(request.getHeader(Constant.ACCESS_TOKEN));
        fileService.batchDeleteMyFile(list, userId);
        return DataResult.success();
    }
}
