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
    public static final String JWT_REFRESH_TOKEN_BLACKLIST = "jwt-refresh-token-blacklist_";

    /**
     * 正常 token
     */
    public static final String ACCESS_TOKEN = "authorization";

    /**
     *  刷新 token
     */
    public static final String REFRESH_TOKEN = "refresh_token";

    /**
     * 标记用户是否已经被锁定
     */
    public static final String ACCOUNT_LOCK_KEY="account-lock-key_";

    /**
     * 标记用户是否已经删除
     */
    public static final String DELETED_USER_KEY="deleted-user-key_";

    /**
     * 主动去刷新 token key(适用场景 比如修改了用户的角色/权限去刷新token)
     */
    public static final String JWT_REFRESH_KEY="jwt-refresh-key_";

    /**
     * 标记新的access_token
     */
    public static final String JWT_REFRESH_IDENTIFICATION="jwt-refreshed-identification_";

    /**
     * UTF-8 编码的 JSON 格式
     */
    public static final String APPLICATION_JSON_UTF8 = "application/json; charset=utf-8";
}
