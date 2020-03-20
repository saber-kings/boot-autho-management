package com.yingxue.lesson.web.controller;

import com.yingxue.lesson.entity.SysUser;
import com.yingxue.lesson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.web.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public SysUser getUserDetail(@RequestParam(required = false)String id){
        return userService.getUserInfo(id);
    }

}
