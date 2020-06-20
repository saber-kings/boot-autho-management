package com.yingxue.lesson.config;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Saber污妖王
 * TODO: 跨域过滤器
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/20
 * @package com.yingxue.lesson.config
 */
public class CrossOriginFilter implements Filter {
    /**
     * 从配置文件中读取允许访问的非本机地址
     */
    @Value("${cross.origin}")
    private  String origin;

    /**
     * 在每次请求时将跨域配置加入请求头
     *
     * @param request 请求
     * @param response 响应
     * @param chain 过滤器执行链
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        httpResponse.setHeader("Access-Control-Allow-Origin", origin);
        httpResponse.setHeader("Access-Control-Allow-Methods", httpRequest.getMethod());
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", httpRequest.getHeader("Access-ControlRequest-Headers"));
        chain.doFilter(request, response);
    }
}
