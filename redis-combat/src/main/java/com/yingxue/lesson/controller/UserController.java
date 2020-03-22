package com.yingxue.lesson.controller;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.vo.req.LoginReqVO;
import com.yingxue.lesson.vo.req.RegisterReqVO;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/21
 * @Description:com.yingxue.lesson.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录接口")
    public LoginRespVO login(@RequestBody LoginReqVO vo) {
        return userService.login(vo);
    }
    @GetMapping("/user/{id}")
    @ApiOperation(value = "获取用户信息接口")
    public SysUser getUserInfo(@PathVariable("id") String id){
        return userService.getUserInfo(id);
    }

    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册接口")
    public String register(@RequestBody RegisterReqVO vo) {
        return userService.register(vo);
    }

    @GetMapping("/user/code/{phone}")
    @ApiOperation(value = "获取验证码接口")
    public String getCode(@PathVariable("phone")String phone){
        return userService.getCode(phone);
    }

}
