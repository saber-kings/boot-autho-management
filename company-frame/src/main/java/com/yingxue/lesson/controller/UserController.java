package com.yingxue.lesson.controller;

import com.yingxue.lesson.aop.annotation.MyLog;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.entity.SysData;
import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.service.UserService;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.utils.JwtTokenUtil;
import com.yingxue.lesson.vo.req.*;
import com.yingxue.lesson.vo.resp.LoginRespVO;
import com.yingxue.lesson.vo.resp.PageRespVO;
import com.yingxue.lesson.vo.resp.UserOwnRoleRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 用户模块相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.controller
 */
@Slf4j
@RestController
@CrossOrigin
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
        try {
            String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
            String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
            userService.logout(accessToken, refreshToken);
        } catch (Exception e) {
            log.error("logout: {}", e.getLocalizedMessage());
        }
        return DataResult.success();
    }

    @GetMapping("/user/unLogin")
    @ApiOperation(value = "引导客户端去登录")
    public DataResult<Object> unLogin() {
        return DataResult.getResult(BaseResponseCode.TOKEN_ERROR);
    }

    @PostMapping("/users")
    @ApiOperation(value = "分页查询用户接口")
    @RequiresPermissions("sys:user:list")
    @MyLog(title = "组织模块-用户管理", action = "分页查询用户接口")
    public DataResult<PageRespVO<SysUser>> pageInfo(@RequestBody UserPageReqVO vo) {
        return DataResult.success(userService.pageInfo(vo));
    }

    @PostMapping("/user")
    @ApiOperation(value = "新增用户接口")
    @RequiresPermissions("sys:user:add")
    @MyLog(title = "组织模块-用户管理", action = "新增用户接口")
    public DataResult<Object> addUser(@RequestBody @Valid UserAddReqVO vo) {
        DataResult<Object> result = DataResult.success();
        userService.addUser(vo);
        return result;
    }

    @GetMapping("/user/roles/{userId}")
    @ApiOperation(value = "查询用户拥有的角色数据接口")
    @RequiresPermissions("sys:user:role:update")
    @MyLog(title = "组织模块-用户管理", action = "查询用户拥有的角色数据接口")
    public DataResult<UserOwnRoleRespVO> getUserOwnRole(@PathVariable("userId") String userId) {
        return DataResult.success(userService.getUserOwnRole(userId));
    }

    @PutMapping("/user/roles")
    @ApiOperation(value = "保存用户新拥有的角色信息接口")
    @RequiresPermissions("sys:user:role:update")
    @MyLog(title = "组织模块-用户管理", action = "保存用户新拥有的角色信息接口")
    public DataResult<Object> saveUserOwnRole(@RequestBody @Valid UserOwnRoleReqVO vo) {
        DataResult<Object> result = DataResult.success();
        userService.setUserOwnRole(vo);
        return result;
    }

    @GetMapping("/user/token")
    @ApiOperation(value = "jwt 刷新 token 接口")
    @MyLog(title = "组织模块-用户管理", action = "jwt 刷新 token 接口")
    public DataResult<String> refreshToken(HttpServletRequest request) {
        String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
        String s = userService.refreshToken(refreshToken);
        return DataResult.success(s);
    }

    @PutMapping("/user")
    @ApiOperation(value = "列表修改用户信息接口")
    @RequiresPermissions("sys:user:update")
    @MyLog(title = "组织模块-用户管理", action = "列表修改用户信息接口")
    public DataResult<Object> updateUserInfo(@RequestBody @Valid UserUpdateReqVO vo, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = JwtTokenUtil.getUserId(accessToken);
        userService.updateUserInfo(vo, userId);
        return DataResult.success();
    }

    @DeleteMapping("/user")
    @ApiOperation(value = "批量/删除用户接口")
    @RequiresPermissions("sys:user:delete")
    @MyLog(title = "组织模块-用户管理", action = "批量/删除用户接口")
    public DataResult<Object> deletedUsers(@RequestBody @ApiParam("用户id集合") List<String> list, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String operationId = JwtTokenUtil.getUserId(accessToken);
        userService.deletedUsers(list, operationId);
        return DataResult.success();
    }

    @GetMapping("/user/info")
    @ApiOperation(value = "用户信息详情接口")
    @MyLog(title = "组织模块-用户管理", action = "用户信息详情接口")
    public DataResult<SysUser> detailInfo(HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        return DataResult.success(userService.detailInfo(JwtTokenUtil.getUserId(accessToken)));
    }

    @PutMapping("/user/info")
    @ApiOperation(value = "保存个人用户信息接口")
    @MyLog(title = "组织模块-用户管理", action = "保存个人用户信息接口")
    public DataResult<Object> saveUserInfo(@RequestBody @Valid UserUpdateDetailInfoReqVO vo, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        userService.userUpdateDetailInfo(vo, JwtTokenUtil.getUserId(accessToken));
        return DataResult.success();
    }

    @PutMapping("/user/pwd")
    @ApiOperation(value = "修改个人用户密码接口")
    @MyLog(title = "组织模块-用户管理", action = "修改个人用户密码接口")
    public DataResult<Object> updatePwd(@RequestBody @Valid UserUpdatePwdReqVO vo, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
        userService.userUpdatePwd(vo, accessToken, refreshToken);
        return DataResult.success();
    }

    @GetMapping("/user/datas")
//    @RequiresPermissions("sys:user:list")
    @ApiOperation(value = "查询用户表数据列接口")
    public DataResult<List<SysData>> getItems() {
        List<SysData> items = userService.getItems();
        return DataResult.success(items);
    }
}
