package com.indata.service.web;

import com.indata.service.web.config.ApplicationConfig;
import com.indata.service.web.config.DataSourceConfig;
import com.indata.service.web.config.MybatisConfig;
import com.indata.service.web.config.WebMvcConfig;
import com.indata.service.web.filter.UserSessionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yangqi
 */
@SpringBootApplication(
        scanBasePackageClasses={
                ApplicationConfig.class,
                WebMvcConfig.class,
                MybatisConfig.class,
                DataSourceConfig.class,
                UserSessionFilter.class
        },
        exclude = {
        DataSourceAutoConfiguration.class
})
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        logger.info("============================= spring boot start begin =============================");
        long start = System.currentTimeMillis();
        SpringApplication.run(Bootstrap.class, args);
        logger.info("============================= SpringApplication.run finished, cost = {} =============================", (System.currentTimeMillis() - start));
        long cost = System.currentTimeMillis() - start;
        logger.info("============================= spring boot start successful ! cost = {} =============================", cost);

    }




}
