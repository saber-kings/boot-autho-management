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
 * @author Saber污妖王
 * TODO: Swagger 配置类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/24
 * @package com.yingxue.lesson.config
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
                new Tag("视图模块", "跳转视图相关接口"),
                new Tag("首页模块", "首页模块相关接口"),
                new Tag("组织管理-菜单权限管理", "菜单权限管理相关接口"),
                new Tag("组织管理-角色管理", "角色管理相关接口"),
                new Tag("组织管理-部门管理", "部门管理相关接口"),
                new Tag("系统管理-日志管理", "日志管理相关接口"),
                new Tag("系统管理-字典管理", "数据字典管理相关接口"),
                new Tag("文件系统-我的文件", "文件操作相关接口"),
                new Tag("文件系统-轮播图管理", "轮播图功能相关接口"),
        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SaberKing")
                .description("Spring Boot 实战后台权限管理系统")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
