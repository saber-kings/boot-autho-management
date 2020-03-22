package com.yingxue.lesson;

import com.yingxue.lesson.entity.User;
import com.yingxue.lesson.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootTest
class RedisTemplateApplicationTests {

//    @Autowired
//    private RedisTemplate<Object, Object> redisTemplate;
//    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
    }
    @Test
    void testRedis(){
//        redisTemplate.opsForValue().get("num");
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.opsForValue().set("username","张三");
//        System.out.println(redisTemplate.opsForValue().get("username"));
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("666666");
//        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisService.hasKey("num"));

        User user = new User();
        user.setUsername("admin");
        user.setPassword("666666");
        redisService.set("user", user);
    }
}
