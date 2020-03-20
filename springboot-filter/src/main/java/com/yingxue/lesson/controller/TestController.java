package com.yingxue.lesson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/19
 * @Description:com.yingxue.lesson.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/user/filter")
    public String hello() {
        return "我被myFilter过滤器监控了";
    }

    @GetMapping("/home/open/info")
    public String getHome(){
        return "欢迎访问首页！";
    }

    @GetMapping("/open/unLogin")
    public String getUnLogin(){
        return "登录失效，请重新登录！";
    }
}
