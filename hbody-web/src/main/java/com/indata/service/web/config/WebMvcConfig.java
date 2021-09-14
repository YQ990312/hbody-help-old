package com.indata.service.web.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.indata.service.web.filter.UserSessionFilter;
import com.indata.service.web.intercepter.UserLoginInterception;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangqi
 */
@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {
                "com.indata.service.web.controller",
                "com.indata.service.web.aop"
        }
)
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private UserSessionFilter userSessionFilter;

    /**
     * 文件上传下载
     *
     * @return
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        log.info("==== hbodyHelp-init commonsMultipartResolver execute ====");

        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxInMemorySize(200 * 1024 * 1024);
        resolver.setMaxUploadSize(200 * 1024 * 1024);
        resolver.setResolveLazily(true);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    /**
     * 添加过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<UserSessionFilter> systemUrlFilterBean() {

        FilterRegistrationBean<UserSessionFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(userSessionFilter);
        registrationBean.addInitParameter("targetFilterLifecycle", "true");
        registrationBean.addUrlPatterns("/*");
        String excludeUrl = "/apiUser/login/passwordLogin" +
                ",";
        registrationBean.addInitParameter("exclusions", excludeUrl);
        registrationBean.setName("accountSessionFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);
        registrar.registerFormatters(registry);
        registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
        registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd HH:mm:ss"));
        registry.addConverter(new LocalTimeConverter("HH:mm"));
        registry.addConverter(new MyDateConverter());
    }

    /**
     * 数据格式
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("==== hbodyHelp-init mappingJackson2HttpMessageConverter execute ====");
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        //配置序列化格式
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        //配置反序列化格式
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //注册自定义策略
        objectMapper.registerModule(javaTimeModule);

        converters.parallelStream()
                //过滤出MappingJackson2HttpMessageConverter
                .filter(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter)
                //将所有MappingJackson2HttpMessageConverter中的objectMapper替换成自定义的策略
                .forEach(httpMessageConverter -> ((MappingJackson2HttpMessageConverter) httpMessageConverter).setObjectMapper(objectMapper));
    }

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("==== hbodyHelp-init addInterceptors init ====");
        // 授权拦截
        registry.addInterceptor(userLoginInterceptor())
                .addPathPatterns("/hbody/help/**")
                .excludePathPatterns("/hbody/help/test/**")
        ;
    }

    @Bean
    public UserLoginInterception userLoginInterceptor() {
        return new UserLoginInterception();
    }

}
