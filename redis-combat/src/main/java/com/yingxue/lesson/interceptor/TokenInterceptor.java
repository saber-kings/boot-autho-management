package com.yingxue.lesson.interceptor;

import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/21
 * @Description:com.yingxue.lesson.interceptor
 * @version:1.0
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(4001002, "用户凭证不能为空，请重新登陆！");
        }else {
            if (!redisService.hasKey(token)) {
                throw new BusinessException(4001002, "用户凭证无效，请重新登陆！");
            }
            String userId = (String) redisService.get(token);
            if (redisService.hasKey(userId)&&!token.equals(redisService.get(userId))) {
                throw new BusinessException(4001002, "您的账号已经在异地登录，请重新登陆！");
            }
        }
        return true;
    }
}
