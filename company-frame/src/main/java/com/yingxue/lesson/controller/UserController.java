package com.yingxue.lesson.controller;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.AddUserReqVO;
import com.yingxue.lesson.vo.req.LoginReqVO;
import com.yingxue.lesson.vo.req.UserPageReqVO;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: Saber污妖王
 * TODO: 用户模块接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
 */
@RestController
@RequestMapping("/api")
@Api(tags = "组织模块-用户管理")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录接口")
    public DataResult<LoginRespVO> login(@RequestBody @Valid LoginReqVO vo) {
        return DataResult.success(userService.login(vo));
    }

    @GetMapping("/user/logout")
    @ApiOperation(value = "用户登出接口")
    public DataResult<Object> logout(HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
        userService.logout(accessToken, refreshToken);
        return DataResult.success();
    }

    @GetMapping("/user/unLogin")
    @ApiOperation(value = "引导客户端去登录")
    public DataResult<Object> unLogin() {
        return DataResult.getResult(BaseResponseCode.TOKEN_ERROR);
    }

    @PostMapping("/users")
    @ApiOperation(value = "分页查询用户接口")
//    @RequiresPermissions("sys:user:list")
    public  DataResult<PageRespVO<SysUser>> pageInfo(@RequestBody UserPageReqVO vo){
        return DataResult.success(userService.pageInfo(vo));
    }

    @PostMapping("/user")
    @ApiOperation(value = "新增用户接口")
//    @RequiresPermissions("sys:user:list")
    public  DataResult<Object> addUser(@RequestBody @Valid AddUserReqVO vo){
        DataResult<Object> result = DataResult.success();
        userService.addUser(vo);
        return result;
    }

}
