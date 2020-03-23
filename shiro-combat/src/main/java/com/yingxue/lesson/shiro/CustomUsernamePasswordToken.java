package com.yingxue.lesson.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @Author: Saber污妖王
 * TODO:类文件简单描述
 * @UpdateUser: luanz
 * @Project: boot-autho-management
 * @Date: 2020/3/22
 * @Description: 描述信息
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
public class CustomUsernamePasswordToken extends UsernamePasswordToken {
    private String token;

    public CustomUsernamePasswordToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }
}
