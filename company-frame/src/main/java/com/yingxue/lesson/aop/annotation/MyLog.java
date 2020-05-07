package com.yingxue.lesson.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author: Saber污妖王
 * TODO: 自定义切面注解
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/1
 * @Package: com.yingxue.lesson.aop.annotation
 * @Version: 0.0.1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    /**
     * 记录用户操作哪个模块
     */
    String title() default "";

    /**
     * 记录用户操作的动作
     */
    String action() default "";
}
