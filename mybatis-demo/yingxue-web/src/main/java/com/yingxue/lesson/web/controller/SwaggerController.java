package com.yingxue.lesson.web.controller;

import com.yingxue.lesson.vo.req.SwaggerReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.web.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "测试Swagger接口")
public class SwaggerController {
    @ApiOperation(value = "我的第一个Swagger接口")
    @PostMapping("/swagger")
    public SwaggerReqVo testSwagger(@RequestBody SwaggerReqVo vo){
        return vo;
    }
}
