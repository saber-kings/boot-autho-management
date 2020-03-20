package com.yingxue.lesson.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/19
 * @Description:com.yingxue.lesson.filter
 * @version:1.0
 */
//@WebFilter(urlPatterns = "/api/*", filterName = "myFilter")
//@Order(1)
public class MyFilter implements Filter {
    @Value("${open.url}")
    private String openUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter 被初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        String method = request.getMethod();
        System.out.println("请求的接口=" + uri + "请求的方式=" + method);
        //判断是否是否是开放性api
        PathMatcher pathMatcher = new AntPathMatcher();
        if (pathMatcher.match(openUrl,uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)){
                servletRequest.getRequestDispatcher("/api/open/unLogin").forward(servletRequest,servletResponse);
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        //判断是否携带凭证
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter 被销毁了");
    }
}
