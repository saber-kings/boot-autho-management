package com.yingxue.lesson.utils;

import com.yingxue.lesson.entity.TokenSettings;
import org.springframework.stereotype.Component;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/18
 * @Description:com.yingxue.lesson.utils
 * @version:1.0
 */
@Component
public class StaticInitializerUtil {

    private TokenSettings tokenSettings;

    public StaticInitializerUtil(TokenSettings tokenSettings) {
        JwtTokenUtil.setTokenSettings(tokenSettings);
    }
}
