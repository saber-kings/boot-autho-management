package com.yingxue.lesson.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Saber污妖王
 * TODO: 视图跳转相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/26
 * @package com.yingxue.lesson.controller
 */
@Controller
@RequestMapping("/index")
@Api(tags = "视图模块")
public class IndexController {
    @GetMapping("/404")
    @ApiOperation("跳转404错误页面")
    public String error404() {
        return "error/404";
    }

    @GetMapping("/login")
    @ApiOperation("跳转登陆页面")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    @ApiOperation("跳转首页页面")
    public String home() {
        return "home";
    }

    @GetMapping("/main")
    @ApiOperation("跳转主页页面")
    public String main() {
        return "main";
    }

    @GetMapping("/menus")
    @ApiOperation("跳转菜单权限管理页面")
    public String menus() {
        return "menus/menu";
    }

    @GetMapping("/menus/page")
    @ApiOperation("跳转菜单权限分页管理页面")
    public String menusPage() {
        return "menus/menu_page";
    }

    @GetMapping("/roles")
    @ApiOperation("跳转角色管理页面")
    public String roles() {
        return "roles/role";
    }

    @GetMapping("/depts")
    @ApiOperation("跳转部门管理页面")
    public String depts() {
        return "depts/dept";
    }

    @GetMapping("/users")
    @ApiOperation("跳转用户管理页面")
    public String users() {
        return "users/user";
    }

    @GetMapping("/logs")
    @ApiOperation("跳转日志管理页面")
    public String logs() {
        return "logs/log";
    }

    @GetMapping("/users/info")
    @ApiOperation("跳转个人用户信息编辑页面")
    public String usersInfo() {
        return "/users/user_edit";
    }

    @GetMapping("/users/pwd")
    @ApiOperation("跳转个人用户修改页面")
    public String updatePwd() {
        return "/users/user_pwd";
    }

    @GetMapping("/rotations")
    @ApiOperation("轮播图管理页面入口")
    public String rotations() {
        return "/rotations/rotation";
    }

    @GetMapping("/rotation/show")
    @ApiOperation("轮播图前端页面展示入口")
    public String rotationShow() {
        return "/rotations/rotation_show";
    }

    @GetMapping("/files/my")
    @ApiOperation("我的文件管理页面入口")
    public String myFile() {
        return "/files/my_file";
    }
}
