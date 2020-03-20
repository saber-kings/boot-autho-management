package com.yingxue.lesson.config;

import com.yingxue.lesson.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/19
 * @Description:com.yingxue.lesson.config
 * @version:1.0
 */
@Configuration
public class FilterConfig {

    @Bean
    public MyFilter myFilter(){
        return new MyFilter();
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(MyFilter myFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/api/*");
        filterRegistrationBean.setName("myFilter");
        return filterRegistrationBean;
    }
}
