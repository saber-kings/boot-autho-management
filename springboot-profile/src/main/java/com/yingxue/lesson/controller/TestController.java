package com.yingxue.lesson.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/18
 * @Description:com.yingxue.lesson.controller
 * @version:1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${branch}")
    private String branch;

    @GetMapping("/branch")
    public String test(){
        return branch;
    }
}
