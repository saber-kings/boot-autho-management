package com.yingxue.lesson.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Saber污妖王
 * TODO:类文件简单描述
 * @UpdateUser: luanz
 * @Project: boot-autho-management
 * @Date: 2020/3/22
 * @Description: 自定义Realm域
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
public class CustomRealm extends AuthorizingRealm {
    /**
     * mock 用户信息
     * 模拟数据库中的用户名和密码
     */
    private Map<String, String> userMap = new HashMap<>();

    /**
     * 使用代码块初始化数据
     */ {
        userMap.put("admin", "123456");
        userMap.put("test", "123456");
    }

    /**
     * 用户授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username= (String) principals.getPrimaryPrincipal();
        //从数据库或者缓存中获取角色数据
        List<String> roles = getRolesByUsername(username);
        //从数据库或者缓存中获取权限数据
        List<String> permissions = getPermissionsByUsername(username);
        //创建AuthorizationInfo，并设置角色和权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取登录用户名
        String username = (String) token.getPrincipal();
        //通过用户名到数据库获取用户信息
        String password = getPasswordByUsername(username);
        if (password == null) {
            return null;
        }
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, getEncPassword(password), getName());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, getEncPassword(password, username), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(username));
        return info;
    }

    /**
     * 通过用户名查询密码，模拟数据库查询
     */
    private String getPasswordByUsername(String username) {
        return userMap.get(username);
    }

    /**
     * 模拟通过数据库获取权限数据
     */
    private List<String> getPermissionsByUsername(String username) {
        List<String> permissions = new ArrayList<>();
        /**
         * 只有是 admin 用户才有 新增、删除权限
         */
        if(username.equals("admin")){
            permissions.add("*");
        }
        permissions.add("user:list");
        permissions.add("user:deleted");
        permissions.add("user:edit");
        return permissions;
    }

    /**
     * 模拟通过数据库获取用户角色信息
     */
    private List<String> getRolesByUsername(String username) {
        List<String> roles = new ArrayList<>();
        if(username.equals("admin")){
            roles.add("admin");
        }
        roles.add("test");
        return roles;
    }

    /**
     * 获得密文密码
     */
//    private String getEncPassword(String password){
//        return new Md5Hash(password, null,3).toString();
//    }
    private String getEncPassword(String password, String salt){
        return new Md5Hash(password, salt,3).toString();
    }
}
