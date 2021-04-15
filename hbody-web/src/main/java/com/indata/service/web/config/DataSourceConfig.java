package com.indata.service.web.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yangqi
 * @create 2021/4/14 20:45
 * druid配置,没有做druid专属配置
 * 还有一个过滤器没有配置
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSourceMaster() {
        return DruidDataSourceBuilder.create().build();
    }
}
