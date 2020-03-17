package com.yingxue.lesson.entity;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/17
 * @Description:com.yingxue.lesson.entity
 * @version:1.0
 */
public class Employee {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
