package com.yingxue.lesson.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author: 小霍
 * TODO: 获取 http 上下文
 * @UpdateUser: Saber污妖王
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.utils
 * @Version: 0.0.1
 */
public class HttpContextUtils {

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
	}
}
