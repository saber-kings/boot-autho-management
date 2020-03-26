package com.yingxue.lesson.shiro;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;

/**
 * @Author: Saber污妖王
 * TODO: 自定义 Realm 域
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/26
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
public class CustomRealm extends AuthorizingRealm {
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof CustomUsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String accessToken = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Claims claims = JwtTokenUtil.getClaimsFromToken(accessToken);
        /**
         * 返回该用户的角色信息给授权器
         */
        if (claims.get(Constant.JWT_ROLES_KEY) != null) {
            info.addRoles((Collection<String>) claims.get(Constant.JWT_ROLES_KEY));
        }

        /**
         * 返回该用户的权限信息给授权器
         */
        if (claims.get(Constant.JWT_PERMISSIONS_KEY) != null) {
            info.addStringPermissions((Collection<String>) claims.get(Constant.JWT_PERMISSIONS_KEY));
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CustomUsernamePasswordToken customUsernamePasswordToken = (CustomUsernamePasswordToken) token;
        return new SimpleAuthenticationInfo(customUsernamePasswordToken.getPrincipal(), customUsernamePasswordToken.getCredentials(), CustomRealm.class.getName());
    }
}
