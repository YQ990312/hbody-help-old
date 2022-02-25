package com.indata.service.web;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangqi
 */
@Slf4j
@MapperScan(basePackages = {"com.indata.service.dal.dao"})
@SpringBootApplication(scanBasePackages = { "com.indata" })
public class BootStrap {

    public static void main(String[] args) {

        log.info("============================= BodyApplicaiton Spring boot start begin =============================");
        long start = System.currentTimeMillis();
        SpringApplication.run(BootStrap.class, args);
        log.info("============================= BodyApplicaiton.run finished, cost = {} =============================", (System.currentTimeMillis() - start));
        long cost = System.currentTimeMillis() - start;
        log.info("============================= BodyApplicaiton Spring boot start successful ! cost = {} =============================", cost);

    }
}
