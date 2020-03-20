package com.yingxue.lesson.model;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/18
 * @Description:com.yingxue.lesson.model
 * @version:1.0
 */
public class UserInfo {
    private String userId;
    private String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
