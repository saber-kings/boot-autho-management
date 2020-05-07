package com.yingxue.lesson.shiro;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.service.RedisService;
import com.yingxue.lesson.utils.JwtTokenUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Saber污妖王
 * TODO: 自定义用户凭证验证器
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/26
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
public class CustomHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Resource
    private RedisService redisService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        CustomUsernamePasswordToken customUsernamePasswordToken = (CustomUsernamePasswordToken) token;
        String accessToken = (String) customUsernamePasswordToken.getPrincipal();
        String userId = JwtTokenUtil.getUserId(accessToken);
        // 判断用户是否被锁定
        if (redisService.hasKey(Constant.ACCOUNT_LOCK_KEY + userId)) {
            throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK);
        }
        // 判断用户是否被删除
        if (redisService.hasKey(Constant.DELETED_USER_KEY + userId)) {
            throw new BusinessException(BaseResponseCode.ACCOUNT_HAS_DELETED_ERROR);
        }
        // 判断 token 是否主动登出
        if (redisService.hasKey(Constant.JWT_ACCESS_TOKEN_BLACKLIST + accessToken)) {
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        // 判断token是否通过校验
        if (!JwtTokenUtil.validateToken(accessToken)) {
            throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE_INVALID);
        }

        // 判断用户是否被标记了
        if (redisService.hasKey(Constant.JWT_REFRESH_KEY + userId)) {
            // 判断用户是否已经刷新过 token 了
            /*
             * 通过剩余的过期时间比较如 果 token 的剩余过期时间大与标记 key 的剩余过期时间
             * 就说明这个 token 是在这个标记 key 之后生成的
             */
            if (redisService.getExpire(Constant.JWT_REFRESH_KEY + userId, TimeUnit.MILLISECONDS) > JwtTokenUtil.getRemainingTime(accessToken)){
                throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE_INVALID);
            }
        }
        return true;
    }
}
