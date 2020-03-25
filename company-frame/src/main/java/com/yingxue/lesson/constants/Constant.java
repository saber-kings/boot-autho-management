package com.yingxue.lesson.constants;

/**
 * @Author: Saber污妖王
 * TODO: 常量类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.constants
 * @Version: 0.0.1
 */
public class Constant {
    /**
     * 用户名称 key
     */
    public static final String JWT_USER_NAME = "jwt-user-name-key";

    /**
     * 权限key
     */
    public static final String JWT_PERMISSIONS_KEY = "jwt-permissions-key_";

    /**
     * 角色key
     */
    public static final String JWT_ROLES_KEY = "jwt-roles-key_";

    /**
     * refresh_token 主动退出后加入黑名单 key
     */
    public static final String JWT_REFRESH_TOKEN_BLACKLIST="jwt-refresh-token-blacklist_";

    /**
     * 正常token
     */
    public static final String ACCESS_TOKEN="authorization";

    /**
     * 刷新token
     */
    public static final String REFRESH_TOKEN="refresh_token";
}
