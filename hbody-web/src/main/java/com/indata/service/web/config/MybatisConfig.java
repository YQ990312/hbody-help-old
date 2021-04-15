package com.indata.service.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yangqi
 * @create 2021/4/13 20:06
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {
        "com.indata.service.dal.dao"
})
public class MybatisConfig {
    /**
     * 有配置数据源
     * org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
     * 有提供自动配置，这里不需要配置
     * SqlSessionFactory
     * DataSourceTransactionManager
     * ConfigurationCustomizer
     */
}
