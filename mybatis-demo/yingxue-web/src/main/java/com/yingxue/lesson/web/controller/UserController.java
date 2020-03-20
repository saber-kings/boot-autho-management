package com.yingxue.lesson.web.controller;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.vo.req.RegisterReqVO;
import com.yingxue.lesson.vo.req.UpdateUserReqVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.web.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = {"用户模块"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户详情")
    @ApiResponses({
            @ApiResponse(code = 0, message = "响应成功", response = SysUser.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", paramType = "query",
                    required = true,defaultValue = "9a26f5f1-cbd2-473d-82db-1d6dcf4598f8")
    })
    public SysUser getUserDetail(@ApiParam(value = "用户id", required = true) @RequestParam String id, HttpServletRequest request) {
        System.out.println(request.getHeader("token"));
        return userService.getUserInfo(id);
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "REST风格获取用户详情接口")
    public SysUser getUserInfo(@PathVariable("id") String id) {
        return userService.getUserInfo(id);
    }

    @PostMapping("/user")
    @ApiOperation(value = "新增用户接口")
    public String insertUser(@RequestBody RegisterReqVO vo) {
        return userService.register(vo);
    }

    @PutMapping("user")
    @ApiOperation(value = "更新用户接口")
    public String updateUser(@RequestBody UpdateUserReqVO vo) {
        return userService.updateUserInfo(vo);
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "删除用户接口")
    public String deletedUserInfo(@PathVariable("id") String id) {
        return userService.deletedUserInfo(id);
    }
}
