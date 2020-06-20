package com.yingxue.lesson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.yingxue.lesson.config.CrossOriginFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author Saber 污妖王
 */
@SpringBootApplication
@MapperScan("com.yingxue.lesson.mapper")
public class CompanyFrameApplication {
    static {
        // FastJson 预热
        new ParserConfig();
        new SerializeConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(CompanyFrameApplication.class, args);
    }

    /**
     * 得到一个跨域过滤器
     * @return com.yingxue.lesson.config.CrossOriginFilter
     */
    @Bean
    public CrossOriginFilter crossOriginFilter(){
        return new CrossOriginFilter();
    }

    /**
     * 将跨域过滤器加入过滤器链，配合 CrossOriginFilter 一起使用
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<CrossOriginFilter> filterRegistrationBean(){
        FilterRegistrationBean<CrossOriginFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setName("crossOriginFilter");
        filterRegistrationBean.setFilter(crossOriginFilter());
        filterRegistrationBean.addUrlPatterns("/api/*");
        return filterRegistrationBean;
    }
}
