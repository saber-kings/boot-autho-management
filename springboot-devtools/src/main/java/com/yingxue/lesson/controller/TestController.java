package com.yingxue.lesson.controller;

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

    @GetMapping("/hello")
    public String test(){
        return "Hello World!";
    }

}
