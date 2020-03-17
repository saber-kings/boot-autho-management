package com.yingxue.lesson;

import com.yingxue.lesson.entity.Person;
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
    void TestPerson() {
        System.out.println(person.toString());
    }

}
