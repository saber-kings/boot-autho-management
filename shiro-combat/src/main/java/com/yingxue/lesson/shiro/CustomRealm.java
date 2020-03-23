package com.yingxue.lesson.shiro;

import com.yingxue.lesson.service.RedisService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO:类文件简单描述
 * @UpdateUser: luanz
 * @Project: boot-autho-management
 * @Date: 2020/3/22
 * @Description: 自定义域
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof CustomUsernamePasswordToken;
    }

    /**
     * 主要业务：
     * 系统业务出现要验证用户的角色权限的时候，就会调用这个方法
     * 来获取该用户所拥有的角色/权限
     * 这个用户授权的方法我们可以缓存起来不用每次都调用这个方法。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String token = (String) principals.getPrimaryPrincipal();
        String userId = (String) redisService.get(token);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(getRolesByUserId(userId));
        info.addStringPermissions(getPermissionByUserId(userId));
        return info;
    }

    /**
     * 主要业务：
     * 当业务代码调用 subject.login(customUsernamePasswordToken); 方法后
     * 就会自动调用这个方法 验证用户名/密码
     * 这里我们改造成 验证 token 是否有效 已经自定义了 shiro 验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        CustomUsernamePasswordToken token = (CustomUsernamePasswordToken) authenticationToken;
        return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());
    }

    /**
     * 获取用户的角色
     * 这里先用伪代码代替
     * 后面权限管理系统 再从 DB 读取
     */
    private List<String> getRolesByUserId(String userId) {
        List<String> roles = new ArrayList<>();
        if (userId.equals("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8")) {
            roles.add("admin");
        }
        roles.add("test");
        return roles;
    }

    /**
     * 获取用户的权限
     * 这里先用伪代码代替
     * 后面权限管理系统 再从 DB 读取
     */
    private List<String> getPermissionByUserId(String userId) {
        List<String> permissions = new ArrayList<>();
        //只有是 admin 用户才拥有所有权限
        if (userId.equals("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8")) {
            permissions.add("*");
        }
        permissions.add("sys:user:list");
        permissions.add("sys:user:edit");
        return permissions;
    }
}
