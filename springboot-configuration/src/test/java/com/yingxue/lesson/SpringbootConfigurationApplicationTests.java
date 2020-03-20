package com.yingxue.lesson;

import com.yingxue.lesson.entity.Person;
import com.yingxue.lesson.utils.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootConfigurationApplicationTests {

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
    }

    @Test
    void testPerson() {
        System.out.println(person.toString());
    }

    @Test
    void testToken() {
        System.out.println(JwtTokenUtil.getToken());
    }

}
