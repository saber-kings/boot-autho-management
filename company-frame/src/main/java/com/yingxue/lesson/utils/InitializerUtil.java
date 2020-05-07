package com.yingxue.lesson.utils;

import org.springframework.stereotype.Component;

/**
 * @Author: Saber污妖王
 * TODO: JWT 初始化配置代理类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.utils
 * @Version: 0.0.1
 */
@Component
public class InitializerUtil {
//    private TokenSettings tokenSettings;

    public InitializerUtil(TokenSettings tokenSettings) {
        JwtTokenUtil.setTokenSettings(tokenSettings);
    }
}
