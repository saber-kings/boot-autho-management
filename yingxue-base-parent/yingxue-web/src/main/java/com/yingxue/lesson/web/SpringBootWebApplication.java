package com.yingxue.lesson.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/17
 * @Description:com.yingxue.lesson.web
 * @version:1.0
 */
@SpringBootApplication(scanBasePackages = "com.yingxue.lesson")
public class SpringBootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
