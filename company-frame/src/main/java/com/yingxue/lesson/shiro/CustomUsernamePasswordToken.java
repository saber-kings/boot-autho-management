package com.yingxue.lesson.shiro;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Saber污妖王
 * TODO: 自定义 UsernamePasswordToken
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.shiro
 * @version 0.0.1
 */
@AllArgsConstructor
public class CustomUsernamePasswordToken extends UsernamePasswordToken {
    private final String token;

    @Override
    public Object getPrincipal() {
        return token;
    }
}
