package com.yingxue.lesson.controller;

import com.yingxue.lesson.model.UserInfo;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/18
 * @Description:com.yingxue.lesson.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/test")
public class MockMvcController {
    @GetMapping("/user")
    public UserInfo getUser(@RequestParam(required = false) String name, @RequestParam(required = false) String userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setUserId(userId);
        return userInfo;
    }
    @PostMapping("/user")
    public UserInfo getUser(@RequestBody UserInfo userInfo) {
        return userInfo;
    }
}
