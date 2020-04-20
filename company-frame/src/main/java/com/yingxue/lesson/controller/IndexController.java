package com.yingxue.lesson.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Saber污妖王
 * TODO: 类文件简单描述
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/26
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
 */
@Controller
@RequestMapping("/index")
@Api(tags = "视图模块")
public class IndexController {
    @GetMapping("/404")
    @ApiOperation("跳转404错误页面")
    public String error404(){
        return "error/404";
    }

    @GetMapping("/login")
    @ApiOperation("跳转登陆页面")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    @ApiOperation("跳转首页页面")
    public String home(){
        return "home";
    }

    @GetMapping("/main")
    @ApiOperation("跳转主页页面")
    public String main(){
        return "main";
    }
    
    @GetMapping("/menus")
    @ApiOperation("跳转菜单权限管理页面")
    public String menus(){
        return "menus/menu";
    }

    @GetMapping("/roles")
    @ApiOperation("跳转角色管理页面")
    public String roles(){
        return "roles/role";
    }
}
