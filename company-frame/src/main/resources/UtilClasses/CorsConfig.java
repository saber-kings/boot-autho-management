package com.yingxue.lesson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Saber污妖王
 * TODO: 跨域配置类，使用了它，就不需要使用跨域过滤器了即 com.yingxue.lesson.config.CrossOriginFilter
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/20
 * @package com.yingxue.lesson.config
 */
@Configuration
public class CorsConfig {

    /**
     * 从配置文件中读取允许访问的非本机地址
     */
    @Value("${cross.origin}")
    private  String origin;

    /**
     * 允许跨域请求
     * @return 跨域过滤器
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置你要允许的网站域名，如果全允许则设为 *
        // 遍历数组，将允许访问的地址添加进去
        String [] result = origin.split(",");
        for (String s : result) {
            config.addAllowedOrigin(s);
        }
        // 如果要限制 HEADER 或 METHOD 请自行更改
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        // 这个顺序很重要哦，为避免麻烦请设置在最前
        bean.setOrder(0);
        return bean;
    }
}