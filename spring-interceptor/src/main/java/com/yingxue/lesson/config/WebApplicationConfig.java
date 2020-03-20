package com.yingxue.lesson.config;

import com.yingxue.lesson.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/19
 * @Description:com.yingxue.lesson.config
 * @version:1.0
 */
@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    @Value("${open.url}")
    private String openUrl;

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/api/**").excludePathPatterns(openUrl);
    }
}
