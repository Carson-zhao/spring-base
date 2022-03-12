package com.xiaozhao.base.aop.aspect;

import com.xiaozhao.base.aop.annotation.MultiDataSource;
import com.xiaozhao.base.config.MultiDataSourceHolder;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @Author Carson-Zhao
 * @Description //数据源切面
 * @Date 2022/3/10 22:31
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut(value = "@within(com.xiaozhao.base.aop.annotation.MultiDataSource) || @annotation(com.xiaozhao.base.aop.annotation.MultiDataSource)")
    public void dataSourcePointCut(){}


    @Before("dataSourcePointCut() && @annotation(multiDataSource)")
    public void before(MultiDataSource multiDataSource){

        String dbName = multiDataSource.DBName();

        if (StringUtils.hasLength(dbName)){

            MultiDataSourceHolder.setDatasource(multiDataSource.DBName());
            log.info("current dataSourceName======"+dbName);

        }else {

            log.info("switch datasource fail, use default, or please configure the data source for the annotations,");

        }
    }


    @After("dataSourcePointCut()")
    public void after(){
        MultiDataSourceHolder.clearDataSource();
    }
}
