package com.yingxue.lesson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: luanzhaofei@outlook.com
 * @Date: 2020/3/20
 * @Package: com.yingxue.lesson.config
 * @version: 0.0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.enable}")
    private boolean enable;

    @Bean
    public Docket crateDocket() {
        List<Parameter> parameterList = new ArrayList<>();
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("sessionId").description("Swagger测试用(模拟sessionId传入)非必填 header")
                .modelRef(new ModelRef("String")).parameterType("header").required(false);
        parameterList.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("用户模块", "用户模块相关接口"), getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yingxue.lesson.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList)
                .enable(enable);
    }

    private Tag[] getTags() {
        return new Tag[]{
//                new Tag("订单模块", "订单模块相关接口"),
        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot 2.x视频教程")
                .description("Spring Boot 2.x 零基础到高级的一个实战视频教程")
                .version("1.0")
                .build();
    }
}
