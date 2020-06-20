package com.yingxue.lesson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Saber污妖王
 * TODO: WebMVC配置类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/9
 * @package com.yingxue.lesson.config
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Value("${file.path}")
    private String filePath;

    @Value("${file.static-path}")
    private String fileStaticPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileStaticPath)
                .addResourceLocations("file:" + filePath);
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/layui/**")
                .addResourceLocations("classpath:/static/layui/");
        registry.addResourceHandler("/treetable-lay/**")
                .addResourceLocations("classpath:/static/treetable-lay/");
    }
}
