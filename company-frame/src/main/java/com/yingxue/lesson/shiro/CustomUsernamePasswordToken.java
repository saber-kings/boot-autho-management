package com.yingxue.lesson.shiro;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @Author: Saber污妖王
 * TODO: 自定义 UsernamePasswordToken
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
@AllArgsConstructor
public class CustomUsernamePasswordToken extends UsernamePasswordToken {
    private final String token;

    @Override
    public Object getPrincipal() {
        return token;
    }
}
