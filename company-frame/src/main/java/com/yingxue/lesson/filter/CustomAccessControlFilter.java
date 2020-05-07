package com.yingxue.lesson.filter;

import com.alibaba.fastjson.JSON;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.shiro.CustomUsernamePasswordToken;
import com.yingxue.lesson.utils.DataResult;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Saber污妖王
 * TODO: 自定义 token 过滤器 AccessControlFilter
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.filter
 * @Version: 0.0.1
 */
@Slf4j
public class CustomAccessControlFilter extends AccessControlFilter {
    /**
     * 是否允许访问下一层
     * true：允许，交给下一个 Filter 处理
     * false：会往下执行 onAccessDenied
     *
     * @param request     请求
     * @param response    响应
     * @param mappedValue 参数
     * @return boolean 返回是否放行结果
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    /**
     * 表示访问拒绝时是否自己处理
     * 如果返回 true 表示自己不处理且继续拦截器链的执行
     * 返回 false 表示自己已经处理了（例如重定向到另一个页面）
     *
     * @param request  请求
     * @param response 响应
     * @return boolean
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("请求的方式: {}", httpServletRequest.getMethod());
        log.info("请求的URL: {}", httpServletRequest.getRequestURL().toString());
        //判断客户端是否携带 accessToken
        try {
            String accessToken = httpServletRequest.getHeader(Constant.ACCESS_TOKEN);
            if (StringUtils.isEmpty(accessToken)) {
                throw new BusinessException(BaseResponseCode.TOKEN_NOT_NULL);
            }
            getSubject(request, response).login(new CustomUsernamePasswordToken(accessToken));
        } catch (BusinessException e) {
            customResponse(e.getCode(), e.getDefaultMessage(), response);
            return false;
        } catch (AuthenticationException e) {
            if (e.getCause() instanceof BusinessException) {
                BusinessException exception = (BusinessException) e.getCause();
                customResponse(exception.getCode(), exception.getDefaultMessage(), response);
            } else {
                customResponse(BaseResponseCode.SHIRO_AUTHENTICATION_EXCEPTION.getCode(), BaseResponseCode.SHIRO_AUTHENTICATION_EXCEPTION.getMsg(), response);
            }
            return false;
        }
        return true;
    }

    /**
     * 自定义错误响应
     *
     * @param code     错误码
     * @param msg      错误提示
     * @param response 响应
     */
    private void customResponse(int code, String msg, ServletResponse response) {
        // 自定义异常的类，用户返回给客户端相应的JSON格式的信息
        try {
            DataResult<Object> result = DataResult.getResult(code, msg);
            response.setContentType(Constant.APPLICATION_JSON_UTF8);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            String userJson = JSON.toJSONString(result);
            @Cleanup OutputStream out = response.getOutputStream();
            out.write(userJson.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            log.error("error={}", e.getLocalizedMessage());
        }
    }
}
