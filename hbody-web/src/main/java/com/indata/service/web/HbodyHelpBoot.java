package com.indata.service.web;

import com.indata.service.web.config.*;
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
        scanBasePackageClasses = {
                ApplicationConfig.class,
                WebMvcConfig.class,
                MybatisConfig.class,
                DataSourceConfig.class,
                UserSessionFilter.class
        },
        exclude = {
                DataSourceAutoConfiguration.class
        })
public class HbodyHelpBoot {

    private static final Logger logger = LoggerFactory.getLogger(HbodyHelpBoot.class);

    public static void main(String[] args) {
        logger.info("============================= hbodyHelpBoot Spring boot start begin =============================");
        long start = System.currentTimeMillis();
        SpringApplication.run(HbodyHelpBoot.class, args);
        logger.info("============================= hbodyHelpBoot.run finished, cost = {} =============================", (System.currentTimeMillis() - start));
        long cost = System.currentTimeMillis() - start;
        logger.info("============================= hbodyHelpBoot Spring boot start successful ! cost = {} =============================", cost);

    }


}
