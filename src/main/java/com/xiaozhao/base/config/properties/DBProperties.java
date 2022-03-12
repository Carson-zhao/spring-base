package com.xiaozhao.base.config.properties;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Carson-Zhao
 * @Description //数据源信息获取
 * @Date 2022/3/10 22:15
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DBProperties {

    private List<HikariDataSource> names;

    private HikariDataSource server;

    private HikariDataSource local;
}
