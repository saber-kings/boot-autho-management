package com.yingxue.lesson;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class CompanyFrameApplicationTests {
    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
        Set<String> keys = redisService.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
