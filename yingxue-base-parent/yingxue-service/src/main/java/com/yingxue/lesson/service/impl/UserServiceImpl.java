package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/17
 * @Description:com.yingxue.lesson.service.impl
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String testService() {
        return "testService";
    }
}
