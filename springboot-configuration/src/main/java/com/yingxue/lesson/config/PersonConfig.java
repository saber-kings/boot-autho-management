//package com.yingxue.lesson.config;
//
//import com.yingxue.lesson.entity.Person;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Auther:luanzhaofei@outlook.com
// * @Date:2020/3/17
// * @Description:com.yingxue.lesson.config
// * @version:1.0
// */
//@Configuration
//public class PersonConfig {
//    @Value("${person.username}")
//    private String username;
//    @Value("${person.salary}")
//    private double salary;
//    @Value("${person.age}")
//    private int age;
//    @Value("${person.sex}")
//    private String sex;
//
//    @Bean
//    public Person getPerson(){
//        Person person = new Person();
//        person.setUsername(username);
//        person.setSalary(salary);
//        person.setAge(age);
//        person.setSex(sex);
//        return person;
//    }
//}
