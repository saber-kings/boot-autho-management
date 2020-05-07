package com.yingxue.lesson.utils;

import java.util.UUID;

/**
 * @Author: 小霍
 * TODO: 密码相关工具类
 * @UpdateUser: Saber污妖王
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.utils
 * @Version: 0.0.1
 */
public class PasswordUtils {

    /**
     * 匹配密码
     *
     * @param salt    盐
     * @param rawPass 明文
     * @param encPass 密文
     * @return 匹配结果，若匹配则返回 false，否则返回 true
     */
    public static boolean misMatch(String salt, String rawPass, String encPass) {
        return !new PasswordEncoder(salt).match(encPass, rawPass);
    }

    /**
     * 明文密码加密
     *
     * @param rawPass 明文
     * @param salt 盐
     * @return 密文
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     *
     * @return 盐
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
