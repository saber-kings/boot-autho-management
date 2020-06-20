package com.yingxue.lesson.shiro;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.service.PermissionService;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.service.RoleService;
import com.yingxue.lesson.utils.CastUtils;
import com.yingxue.lesson.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Saber污妖王
 * TODO: 自定义 Realm 域
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/26
 * @package com.yingxue.lesson.shiro
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {
    @Resource
    private RedisService redisService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof CustomUsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String accessToken = (String) principals.getPrimaryPrincipal();
        Claims claims = JwtTokenUtil.getClaimsFromToken(accessToken);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String userId = JwtTokenUtil.getUserId(accessToken);
        log.info("校验权限，userId={}", userId);
        if (redisService.hasKey(Constant.JWT_REFRESH_KEY + userId) &&
                redisService.getExpire(Constant.JWT_REFRESH_KEY + userId, TimeUnit.MILLISECONDS)
                        > JwtTokenUtil.getRemainingTime(accessToken)) {
            List<String> roles = roleService.getNamesByIds(userId);
            if (roles != null && !roles.isEmpty()) {
                info.addRoles(roles);
            }
            List<String> permissions = permissionService.getPermissionByUserId(userId);
            if (permissions != null && !permissions.isEmpty()) {
                info.addStringPermissions(permissions);
            }
        } else {
            //返回该用户的角色信息给授权器
            if (claims.get(Constant.JWT_ROLES_KEY) != null) {
                //将得到的权限 List 集合类型转换成 List<String>，下同
                List<String> roles = CastUtils.castList(claims.get(Constant.JWT_ROLES_KEY, List.class), String.class);
                info.addRoles(roles);
            }

            //返回该用户的权限信息给授权器
            if (claims.get(Constant.JWT_PERMISSIONS_KEY) != null) {
                List<String> permissions = CastUtils.castList(claims.get(Constant.JWT_PERMISSIONS_KEY, List.class), String.class);
                info.addStringPermissions(permissions);
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CustomUsernamePasswordToken customUsernamePasswordToken = (CustomUsernamePasswordToken) token;
        return new SimpleAuthenticationInfo(customUsernamePasswordToken.getPrincipal(), customUsernamePasswordToken.getCredentials(), CustomRealm.class.getName());
    }
}
