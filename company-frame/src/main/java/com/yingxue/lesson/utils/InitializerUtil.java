package com.yingxue.lesson.utils;

import org.springframework.stereotype.Component;

/**
 * @author Saber污妖王
 * TODO: JWT 初始化配置代理类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.utils
 */
@Component
public class InitializerUtil {
    public InitializerUtil(TokenSettings tokenSettings) {
        JwtTokenUtil.setTokenSettings(tokenSettings);
    }
}
