package com.xiaozhao.base.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author Carson-Zhao
 * @Description //数据源路由器
 * @Date 2022/3/10 22:27
 * @Version 1.0
 */
@Slf4j
public class MultiDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        return MultiDataSourceHolder.getDatasource();

    }

}
