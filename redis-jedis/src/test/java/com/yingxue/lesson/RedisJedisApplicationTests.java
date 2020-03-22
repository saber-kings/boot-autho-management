package com.yingxue.lesson;

import com.yingxue.lesson.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisJedisApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedis(){
//        System.out.println(redisService.exists("name"));
        System.out.println(redisService.del("name","name1"));
    }

}
