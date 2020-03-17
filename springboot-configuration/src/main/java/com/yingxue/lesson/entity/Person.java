package com.yingxue.lesson.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/17
 * @Description:com.yingxue.lesson.entity
 * @version:1.0
 */
@ConfigurationProperties(prefix = "person")
@Component
public class Person {
    private String username;
    private double salary;
    private int age;
    private String sex;

    private String[] pets;

    private List<String> list;

    private Map<String, String> friend;

    private List<Map<String, String>> children;

    private Employee employee;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getPets() {
        return pets;
    }

    public void setPets(String[] pets) {
        this.pets = pets;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getFriend() {
        return friend;
    }

    public void setFriend(Map<String, String> friend) {
        this.friend = friend;
    }

    public List<Map<String, String>> getChildren() {
        return children;
    }

    public void setChildren(List<Map<String, String>> children) {
        this.children = children;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", pets=" + Arrays.toString(pets) +
                ", list=" + list +
                ", friend=" + friend +
                ", children=" + children +
                ", employee=" + employee +
                '}';
    }
}
