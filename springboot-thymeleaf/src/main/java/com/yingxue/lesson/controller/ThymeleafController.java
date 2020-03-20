package com.yingxue.lesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/19
 * @Description:com.yingxue.lesson.controller
 * @version:1.0
 */
@Controller
public class ThymeleafController {

    @GetMapping("thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("username", "zhangsan");
        return "index";
    }

}
