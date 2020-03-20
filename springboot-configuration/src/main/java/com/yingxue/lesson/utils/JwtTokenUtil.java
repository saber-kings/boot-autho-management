package com.yingxue.lesson.utils;

import com.yingxue.lesson.entity.TokenSettings;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/18
 * @Description:com.yingxue.lesson.utils
 * @version:1.0
 */
public class JwtTokenUtil {

    private static String secretKey;
    private static String issuer;

    public static void setTokenSettings(TokenSettings tokenSettings) {
        secretKey = tokenSettings.getSecretKey();
        issuer = tokenSettings.getIssuer();
    }

    public static String getToken() {
        return secretKey + issuer;
    }
}
