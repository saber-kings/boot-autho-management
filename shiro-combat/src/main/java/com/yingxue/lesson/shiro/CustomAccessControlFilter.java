package com.yingxue.lesson.shiro;

import com.alibaba.fastjson.JSON;
import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Saber污妖王
 * TODO:类文件简单描述
 * @UpdateUser: luanz
 * @Project: boot-autho-management
 * @Date: 2020/3/22
 * @Description: 描述信息
 * @Package: com.yingxue.lesson.shiro
 * @Version: 0.0.1
 */
@Slf4j
public class CustomAccessControlFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {
            log.info("接口请求方式{}", request.getMethod());
            log.info("接口请求地址{}", request.getRequestURI());
            String token = request.getHeader(Constant.SESSION_ID);
            if (StringUtils.isEmpty(token)) {
                throw new BusinessException(4001001, "用户凭证已失效，请重新登录认证！");
            }
            CustomUsernamePasswordToken customUsernamePasswordToken = new CustomUsernamePasswordToken(token);
            getSubject(servletRequest, servletResponse).login(customUsernamePasswordToken);
        } catch (BusinessException e) {
            customResponse(e.getMessageCode(), e.getDetailMessage(), servletResponse);
            return false;
        } catch (AuthenticationException e) {
            if (e.getCause() instanceof BusinessException) {
                BusinessException businessException = (BusinessException) e.getCause();
                customResponse(businessException.getMessageCode(), businessException.getDetailMessage(), servletResponse);
            } else {
                customResponse(4000001, "用户认证失败", servletResponse);
            }
            return false;
        }catch (Exception e){
            customResponse(5000001, "系统异常", servletResponse);
        }
        return true;
    }

    private void customResponse(int code, String msg, ServletResponse response) {
        try {
            Map<String, Object> result = new HashMap<>();
            result.put("code", code);
            result.put("msg", msg);
            response.setContentType(Constant.APPLICATION_JSON_UTF8);
            response.setCharacterEncoding("UTF-8");
            String json = JSON.toJSONString(result);
            ServletOutputStream out = response.getOutputStream();
            out.write(json.getBytes());
            out.flush();
        } catch (IOException e) {
            log.error("customResponse 响应异常{}", e);
        }
    }
}
