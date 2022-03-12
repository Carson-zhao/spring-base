package com.xiaozhao.base.config;

import com.google.common.collect.Maps;
import com.xiaozhao.base.config.properties.DBProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @Author Carson-Zhao
 * @Description //数据源配置
 * @Date 2022/3/10 22:51
 * @Version 1.0
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Autowired
    private DBProperties dbProperties;



    @Bean(name = "multiDataSource")
    public MultiDataSource multiDataSource(){
        MultiDataSource multiDataSource = new MultiDataSource();

        List<HikariDataSource> names = dbProperties.getNames();

        if (CollectionUtils.isEmpty(names)){
            throw new RuntimeException("please configure the data source!");
        }

        multiDataSource.setDefaultTargetDataSource(names.get(0));

        HashMap<Object, Object> dataSourceMap = Maps.newHashMap();
        int i = 0;
        for (HikariDataSource name : names) {
            dataSourceMap.put("dataSource"+(i++),name);
        }

        multiDataSource.setTargetDataSources(dataSourceMap);

        return multiDataSource;
    }

}
