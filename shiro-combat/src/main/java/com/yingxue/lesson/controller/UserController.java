package com.yingxue.lesson.controller;

import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.vo.req.LoginReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Saber污妖王
 * TODO:类文件简单描述
 * @UpdateUser: luanz
 * @Project: boot-autho-management
 * @Date: 2020/3/23
 * @Description: 描述信息
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户模块")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录接口")
    public Map<String, Object> login(@RequestBody LoginReqVO vo) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("data", userService.login(vo));
        return result;
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "获取用户详情接口")
    @RequiresPermissions("sys:user:detail")
    public Map<String, Object> detail(@PathVariable("id") @ApiParam(value = "用户Id") String id) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("data", userService.detail(id));
        return result;
    }
}
