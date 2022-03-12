package com.xiaozhao.base.config;

/**
 * @Author Carson-Zhao
 * @Description //动态数据源容器
 * @Date 2022/3/10 22:19
 * @Version 1.0
 */
public class MultiDataSourceHolder {

    private static final ThreadLocal<String> threadLocal =new ThreadLocal<>();

    public static void setDatasource(String datasource){
        threadLocal.set(datasource);
    }

    public static String getDatasource(){
        return threadLocal.get();
    }

    public static void clearDataSource(){
        threadLocal.remove();
    }

}
