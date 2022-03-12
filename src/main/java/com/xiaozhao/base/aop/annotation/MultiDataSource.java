package com.xiaozhao.base.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author Carson-Zhao
 * @Description //多数据源自定义注解
 * @Date 2022/3/8 23:23
 * @Version 1.0
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultiDataSource {

    String DBName();

}
