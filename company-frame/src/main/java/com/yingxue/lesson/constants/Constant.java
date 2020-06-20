package com.yingxue.lesson.constants;

/**
 * @author Saber污妖王
 * TODO: 自定义常量类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.constants
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
    public static final String JWT_REFRESH_TOKEN_BLACKLIST = "jwt-refresh_token-blacklist_";

    /**
     * access_token 主动退出后加入黑名单 key
     */
    public static final String JWT_ACCESS_TOKEN_BLACKLIST = "jwt-access_token-blacklist_";

    /**
     * 正常 token
     */
    public static final String ACCESS_TOKEN = "authorization";

    /**
     * 刷新 token
     */
    public static final String REFRESH_TOKEN = "refresh_token";

    /**
     * 标记用户是否已经被锁定
     */
    public static final String ACCOUNT_LOCK_KEY = "account-lock-key_";

    /**
     * 标记用户是否已经删除
     */
    public static final String DELETED_USER_KEY = "deleted-user-key_";

    /**
     * 主动去刷新 token key(适用场景 比如修改了用户的角色/权限去刷新token)
     */
    public static final String JWT_REFRESH_KEY = "jwt-refresh-key_";

//    /**
//     * 标记新的 access_token
//     */
//    public static final String JWT_REFRESH_IDENTIFICATION="jwt-refreshed-identification_";

    /**
     * 部门编码key
     */
    public static final String DEPT_CODE_KEY = "dept-code-key_";

    /**
     * 顶级部门ID
     */
    public static final String DEPT_TOP = "0";

    /**
     * UTF-8 编码的 JSON 格式
     */
    public static final String APPLICATION_JSON_UTF8 = "application/json; charset=utf-8";

    /**
     * 用户权鉴缓存 key
     */
    public static final String IDENTIFY_CACHE_KEY = "shiro-cache:com.yingxue.lesson.shiro.CustomRealm.authorizationCache:";

    /**
     * 获取上传的文件类型 key
     */
    public static final String FILE_TYPE = "file-type_";

    /**
     * IE浏览器 key
     */
    public static final String IE_BROWSER_KEY = "MSIE";

    /**
     * 火狐浏览器 key
     */
    public static final String FIREFOX_BROWSER_KEY = "Firefox";
}
