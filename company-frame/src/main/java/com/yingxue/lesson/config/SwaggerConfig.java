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
 * @Author: Saber污妖王
 * TODO: Swagger 配置类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/24
 * @Package: com.yingxue.lesson.config
 * @Version: 0.0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.enable}")
    private boolean enable;

    @Bean
    public Docket createRestApi() {
        //这是为了我们在用 swagger 测试接口的时候添加头部信息
        List<Parameter> parameterList = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder refreshTokenPar = new ParameterBuilder();
        tokenPar.name("authorization")
                .description("swagger测试用(模拟authorization传入)非必填 header")
                .modelRef(new ModelRef("string"))
                .parameterType("header").required(false);
        refreshTokenPar.name("refresh_token")
                .description("swagger测试用(模拟刷新token传入)非必填 header")
                .modelRef(new ModelRef("string"))
                .parameterType("header").required(false);
        //多个的时候 就直接添加到 pars 就可以了
        parameterList.add(tokenPar.build());
        parameterList.add(refreshTokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("组织模块-用户管理", "用户模块相关接口"), getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yingxue.lesson.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList)
                .enable(enable);
    }

    private Tag[] getTags() {
        return new Tag[]{
                new Tag("测试模块", "测试模块相关接口"),
        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("迎学教育")
                .description("迎学教育-Spring Boot 实战系列")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
